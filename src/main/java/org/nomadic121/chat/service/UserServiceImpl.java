package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.UserForm;
import org.nomadic121.chat.mapper.UserMapper;
import org.nomadic121.chat.repository.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final @NonNull UsersRepository usersRepository;

    @Override
    public void save(final UserForm userForm) {
        usersRepository.save(User.builder()
                .name(userForm.getName())
                .hashPass(userForm.getHashPass())
                .banned(false)
                .build());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

//    public boolean isBanned (final User user) {
//        return usersRepository.findById(user.getId()).get().getBanned();
//    }
//
//    public void ban (final User user) {
//        banned = true;
//    }

}
