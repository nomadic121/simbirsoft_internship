package org.nomadic121.chat.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
public class ChatsRESTController {

    private final @NonNull ChatService chatService;

    @GetMapping("/users")
    public List<ChatDto> getUsersList() {
        return chatService.getAllChats();
    }

}
