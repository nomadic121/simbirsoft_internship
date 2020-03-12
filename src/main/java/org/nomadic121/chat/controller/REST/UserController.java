package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final @NonNull UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUserList() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{UserId}")
    public UserDto getUserById(@PathVariable(name = "UserId",required = true) String userId) {
        if (!userId.isEmpty()) {
            Long id = Long.valueOf(userId);
            try {
                return userService.getOneById(id);
            } catch (EntityNotFoundException e) {
                return null;
            }
        }
        return null;
    }

}
