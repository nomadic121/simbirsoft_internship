package org.nomadic121.chat.controller;

import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersRESTController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsersList() {
        return userService.getAllUsers();
    }

}
