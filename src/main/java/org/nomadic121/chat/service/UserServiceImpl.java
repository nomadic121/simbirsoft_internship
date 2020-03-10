package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.entity.Role;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.UserForm;
import org.nomadic121.chat.mapper.UserMapper;
import org.nomadic121.chat.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final @NonNull UsersRepository usersRepository;

    private final @NonNull PasswordEncoder passwordEncoder;

    @Override
    public void save(final UserForm userForm) {
        usersRepository.save(User.builder()
                .name(userForm.getName())
                .hashPass(passwordEncoder.encode(userForm.getHashPass()))
                .banned(false)
                .roles(Role.USER)
                .build());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

}
