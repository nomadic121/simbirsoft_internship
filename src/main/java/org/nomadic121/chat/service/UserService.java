package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<UserDto> getAllUsers();

}
