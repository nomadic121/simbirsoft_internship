package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final @NonNull ChatService chatService;

    @GetMapping("/chats")
    public List<ChatDto> getChatsList() {
        return chatService.getAllChats();
    }

}
