package org.nomadic121.chat.controllers;

import org.nomadic121.chat.models.Message;
import org.nomadic121.chat.services.MessageService;
import org.nomadic121.chat.services.UserService;
import org.nomadic121.chat.transfer.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/chat")
    public String getChat(@RequestParam(name="name", required=false, defaultValue="") String name, Map<String, Object> model) {
        userService.add(name);
        model.put("message", messageService.getAllMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String postChat(@RequestParam(name="text", required=false, defaultValue="") String text, Map<String, Object> model) {
        messageService.add(text);
        Iterable<MessageDto> messages = messageService.getAllMessages();
        model.put("messages", messages);
        return "chat";
    }

}
