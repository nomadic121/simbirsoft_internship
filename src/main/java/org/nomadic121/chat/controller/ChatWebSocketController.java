package org.nomadic121.chat.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.entity.Message;
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
    public Message getMessages(Message message) throws Exception {
        messageService.add(message);
        return message;
    }

}
