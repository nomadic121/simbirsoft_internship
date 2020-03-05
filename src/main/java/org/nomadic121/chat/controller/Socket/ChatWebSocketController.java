package org.nomadic121.chat.controller.Socket;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.repository.UsersRepository;
import org.nomadic121.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final @NonNull MessageService messageService;

    private final @NonNull UsersRepository usersRepository;

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public MessageForm getMessages(final Authentication authentication, final MessageForm messageForm) throws Exception {
        messageService.save(authentication, (long) 1, messageForm); //TODO chatId
        return messageForm;
    }

}
