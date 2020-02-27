package org.nomadic121.chat.service;

import org.nomadic121.chat.mapper.UserMapper;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.repository.UsersRepository;
import org.nomadic121.chat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepo;

    @Override
    public void add(final User user) {
        userRepo.add(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.getAllUsers().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

}
