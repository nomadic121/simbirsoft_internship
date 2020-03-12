package org.nomadic121.chat.controller.REST;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final @NonNull MessageService messageService;

    @PreAuthorize(value = "hasAuthority('CAN_GET_MESSAGES')")
    @GetMapping("/messages")
    public ResponseEntity<List<MessageDto>> getMessageList() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @PreAuthorize(value = "hasAuthority('CAN_GET_MESSAGES')")
    @GetMapping("/messages/{chatId}")
    public ResponseEntity<List<MessageDto>> getMessageListByChatId(@PathVariable(name = "chatId", required = true) String chatId) {
        try {
            Long id = Long.valueOf(chatId);
            return ResponseEntity.ok(messageService.getMessagesByChatId(id));
        } catch (EntityNotFoundException | NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize(value = "hasAuthority('CAN_GET_MESSAGES')")
    @GetMapping("/message/{messageId}")
    public ResponseEntity<MessageDto> getMessagesById(@PathVariable(name = "messageId", required = true) String messageId) {
        try {
            Long id = Long.valueOf(messageId);
            return ResponseEntity.ok(messageService.getOneById(id));
        } catch (EntityNotFoundException | NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize(value = "hasAuthority('CAN_SEND_MESSAGES')")
    @PostMapping("/messages/{chatId}")
    public ResponseEntity<Void> postMessageByChatId(@PathVariable(name = "chatId", required = true) String chatId,
                                                    Authentication authentication,
                                                    @RequestBody MessageForm messageForm) {
        try {
            Long id = Long.valueOf(chatId);
            messageService.saveAndDeliverMessage(authentication, id, messageForm);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException | NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize(value = "hasAuthority('CAN_EDIT_AND_DELETE_MESSAGES')")
    @DeleteMapping("/messages/{messageId}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable(name = "messageId", required = true) String messageId,
                                                  Authentication authentication) {
        try {
            Long id = Long.valueOf(messageId);
            messageService.deleteMessageById(authentication, id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException | NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize(value = "hasAuthority('CAN_EDIT_AND_DELETE_MESSAGES')")
    @PutMapping("/messages/{messageId}")
    public ResponseEntity<Void> updateMessageById(@PathVariable(name = "messageId", required = true) String messageId,
                                                  Authentication authentication,
                                                  @RequestBody MessageForm messageForm) {
        try {
            Long id = Long.valueOf(messageId);
            messageService.updateMessageById(authentication, id, messageForm);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException | NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}