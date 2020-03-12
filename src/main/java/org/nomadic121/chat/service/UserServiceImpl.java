package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.UserForm;
import org.nomadic121.chat.mapper.UserMapper;
import org.nomadic121.chat.repository.UsersRepository;
import org.nomadic121.chat.util.RoleAuthoritiesManager;
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
    public void createAndSave(final UserForm userForm) {
        usersRepository.save(User.builder()
                .userName(userForm.getName())
                .password(passwordEncoder.encode(userForm.getHashPass()))
                .banned(false)
                .authorities(RoleAuthoritiesManager.USER.getAuthorities())
                .build());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getOneById(final Long id) {
        User user = usersRepository.getOne(id);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public boolean isBanned(final Long id) {
        User user = usersRepository.getOne(id);
        return user.getBanned();
    }

    @Override
    public void ban(final Long id) {
        User user = usersRepository.getOne(id);
        user.setAuthorities(RoleAuthoritiesManager.BANNED.getAuthorities());
        user.setBanned(true);
        usersRepository.save(user);
    }

    @Override
    public void unBan(final Long id) {
        User user = usersRepository.getOne(id);
        user.setAuthorities(RoleAuthoritiesManager.BANNED.getAuthorities());
        user.setBanned(false);
        usersRepository.save(user);
    }

}
