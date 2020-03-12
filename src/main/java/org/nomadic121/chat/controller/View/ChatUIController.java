package org.nomadic121.chat.controller.View;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.ChatForm;
import org.nomadic121.chat.service.AuthenticationService;
import org.nomadic121.chat.service.ChatService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ChatVController {

    private final @NonNull ChatService chatService;

    private final @NonNull AuthenticationService authenticationService;

    @GetMapping("/chatUI")
    public String getChat(@RequestParam(name="chatId", required=false, defaultValue="1") String chatId,
                          ModelMap model) {
        model.addAttribute("chatId", chatId);
        return "chatUI";
    }

    @GetMapping("/chatList")
    public String getChatList(ModelMap model) {
        chatService.getAllChats()
                .forEach(x -> model.addAttribute("chat", x));
        return "chatList";
    }

    @PostMapping("/chatList")
    public String createChat(Authentication authentication, ChatForm chatForm, ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        chatService.createAndSave(user, chatForm);
        chatService.getAllChats()
                .forEach(x -> model.addAttribute("chat", x));
        return "chatList";
    }

}
