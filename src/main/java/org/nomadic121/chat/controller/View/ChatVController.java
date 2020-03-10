package org.nomadic121.chat.controller.View;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.form.ChatForm;
import org.nomadic121.chat.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatVController {

    private final @NonNull ChatService chatService;

    @GetMapping("/chatUI")
    public String getChat(@RequestParam(name="chatId", required=false, defaultValue="main") String chatId, Map<String, Object> model) {
        model.put("chatId", chatId);
        return "chatUI";
    }

    @GetMapping("/chatList")
    public String getChatList(Map<String, Object> model) {
        chatService.getAllChats().forEach(x -> model.put("chat", x));
        return "chatList";
    }

    @PostMapping("/chatList")
    public String createChat(Principal principal, ChatForm chatForm, Map<String, Object> model) {
        chatService.save(principal, chatForm);
        chatService.getAllChats().forEach(x -> model.put("chat", x));
        return "chatList";
    }

}
