package org.nomadic121.chat.controller;

import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ChatUIController {

    @Autowired
    private UserService userService;

    @GetMapping("/chatUI")
    public String getChat(@RequestParam(name = "name", required = false, defaultValue = "") String name, Map<String, Object> model) {
        userService.add(new User(name));
        return "index.html";
    }

}
