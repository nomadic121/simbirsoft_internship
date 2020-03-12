package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public List<MessageDto> getMessageListByChatId(@PathVariable(name = "chatId", required = true) String chatId) {
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
    public MessageDto getMessagesById(@PathVariable(name = "messageId", required = true) String messageId) {
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

    @PostMapping("/messages/{chatId}")
    public ResponseEntity<Void> postMessageByChatId(@PathVariable(name = "chatId", required = true) String chatId,
                                                  Authentication authentication,
                                                  @RequestBody MessageForm messageForm) {
        if (!chatId.isEmpty()) {
            Long id = Long.valueOf(chatId);
            try {
                messageService.saveAndDeliverMessage(authentication, id, messageForm);
                return ResponseEntity.ok().build();
            } catch (EntityNotFoundException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/messages/{messageId}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable(name = "messageId", required = true) String messageId,
                                                  Authentication authentication) {
        if (!messageId.isEmpty()) {
            Long id = Long.valueOf(messageId);
            try {
                messageService.deleteMessageById(authentication, id);
                return ResponseEntity.ok().build();
            } catch (EntityNotFoundException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/messages/{messageId}")
    public ResponseEntity<Void> updateMessageById(@PathVariable(name = "messageId", required = true) String messageId,
                                                  Authentication authentication,
                                                  @RequestBody MessageForm messageForm) {
        if (!messageId.isEmpty()) {
            Long id = Long.valueOf(messageId);
            try {
                messageService.updateMessageById(authentication, id, messageForm);
                return ResponseEntity.ok().build();
            } catch (EntityNotFoundException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

}