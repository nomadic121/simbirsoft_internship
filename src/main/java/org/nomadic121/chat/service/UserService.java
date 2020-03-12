package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.form.UserForm;

import java.util.List;

public interface UserService {

    void createAndSave(UserForm userForm);

    List<UserDto> getAllUsers();

    UserDto getOneById(Long id);
}
