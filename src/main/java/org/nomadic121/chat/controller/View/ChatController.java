package org.nomadic121.chat.controller.View;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final @NonNull UserService userService;

    @GetMapping("/chatUI")
    public String getChat(Map<String, Object> model) {
        return "chatUI.html";
    }

}
