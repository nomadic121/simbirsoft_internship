package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.UserDto;

import java.util.List;

public interface UserService {

    void add(String name);

    List<UserDto> getAllUsers();

}
