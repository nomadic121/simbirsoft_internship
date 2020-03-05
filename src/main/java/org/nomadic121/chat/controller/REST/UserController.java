package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final @NonNull UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsersList() {
        return userService.getAllUsers();
    }

}
