package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final @NonNull ChatService chatService;

    @GetMapping("/chats")
    public List<ChatDto> getChatList() {
        return chatService.getAllChats();
    }

    @GetMapping("/chat/{chatId}")
    public ChatDto getChatById(@PathVariable(name = "chatId", required = true) String chatId) {
        if (!chatId.isEmpty()) {
            Long id = Long.valueOf(chatId);
            try {
                return chatService.getOneById(id);
            } catch (EntityNotFoundException e) {
                return null;
            }
        }
        return null;
    }

}
