package org.nomadic121.chat.services;

import org.nomadic121.chat.models.User;
import org.nomadic121.chat.repositories.UsersRepository;
import org.nomadic121.chat.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepo;

    @Override
    public void add(final String name) {
        userRepo.add(new User(name));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(userRepo.getAllUsers());
    }

}
