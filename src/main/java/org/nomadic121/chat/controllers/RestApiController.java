package org.nomadic121.chat.controllers;

import org.nomadic121.chat.services.MessageService;
import org.nomadic121.chat.services.UserService;
import org.nomadic121.chat.transfer.MessageDto;
import org.nomadic121.chat.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/users")
    public List<UserDto> getUsersList() {
        return userService.getAllUsers();
    }

    @GetMapping("/messages")
    public List<MessageDto> getMessagesList() {
        return messageService.getAllMessages();
    }

}
