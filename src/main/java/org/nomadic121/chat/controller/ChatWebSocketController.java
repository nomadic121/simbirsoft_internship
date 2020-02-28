package org.nomadic121.chat.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final @NonNull MessageService messageService;

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public MessageForm getMessages(MessageForm messageForm) throws Exception {
        messageService.save(Message.builder().message(messageForm.getMessage()).from("usr").build());
        return messageForm;
    }

}
