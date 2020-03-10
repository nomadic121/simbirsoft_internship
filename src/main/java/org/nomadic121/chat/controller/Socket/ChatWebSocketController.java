package org.nomadic121.chat.controller.Socket;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final @NonNull MessageService messageService;

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public MessageForm getMessages(final Principal principal, final MessageForm messageForm) throws Exception {
        messageService.save(principal, (long) 1, messageForm); //TODO chatId
        return messageForm;
    }

}
