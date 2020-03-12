package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final @NonNull MessageService messageService;

    @GetMapping("/messages")
    public List<MessageDto> getMessageList() {
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{chatId}")
    public List<MessageDto> getMessageByChatId(@PathVariable(name = "chatId", required = true) String chatId) {
        if (!chatId.isEmpty()) {
            Long id = Long.valueOf(chatId);
            try {
                return messageService.getMessagesByChatId(id);
            } catch (EntityNotFoundException e) {
                return null;
            }
        }
        return null;
    }

    @GetMapping("/message/{messageId}")
    public MessageDto getMessagesById(@PathVariable(name = "messageId", required = false) String messageId) {
        if (!messageId.isEmpty()) {
            Long id = Long.valueOf(messageId);
            try {
                return messageService.getOneById(id);
            } catch (EntityNotFoundException e) {
                return null;
            }
        }
        return null;
    }

}