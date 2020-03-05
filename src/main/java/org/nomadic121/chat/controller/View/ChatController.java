package org.nomadic121.chat.controller.View;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.form.UserForm;
import org.nomadic121.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final @NonNull UserService userService;

    @GetMapping("/chatUI")
    public String getChat(@RequestParam(name = "name", required = false, defaultValue = "") String name, Map<String, Object> model) {
        userService.save(new UserForm(name, ""));
        return "index.html";
    }

}
