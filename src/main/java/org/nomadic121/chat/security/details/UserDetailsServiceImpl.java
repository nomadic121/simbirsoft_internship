package org.nomadic121.chat.security.details;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final @NonNull UsersRepository usersRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        return new UserDetailsImpl(usersRepository.findOneByUserName(name).orElseThrow(() ->
                new UsernameNotFoundException("User not found")));
    }

}
