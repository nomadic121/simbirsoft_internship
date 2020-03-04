package org.nomadic121.chat.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.entity.User;
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
    public MessageForm getMessages(MessageForm messageForm) throws Exception {
        User usr = usersRepository.findById((long) 1).get();
        messageService.save(Message.builder()
                .text(messageForm.getMessage())
                .author(usr) //TODO autorities
                .build());
        return messageForm;
    }

}
