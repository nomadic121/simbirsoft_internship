package org.nomadic121.chat.controller;

import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public Message getMessages(Message message) throws Exception {
        messageService.add(message);
        return message;
    }

}
