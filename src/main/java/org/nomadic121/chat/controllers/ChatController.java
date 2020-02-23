package org.nomadic121.chat.controllers;

import org.nomadic121.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @GetMapping("/chat")
    public String getChat(@RequestParam String name, Map<String, Object> model) {
        userService.add(name);
        model.put("name", name);
        return "chat";
    }

}
