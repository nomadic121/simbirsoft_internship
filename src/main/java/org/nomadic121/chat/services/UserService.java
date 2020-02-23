package org.nomadic121.chat.services;

import org.nomadic121.chat.transfer.UserDto;

import java.util.List;

public interface UserService {

    void add (String name);

    List<UserDto> getAllUsers ();

}
