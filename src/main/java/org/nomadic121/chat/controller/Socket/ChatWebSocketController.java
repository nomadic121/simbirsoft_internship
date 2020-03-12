package org.nomadic121.chat.controller.Socket;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.AuthenticationService;
import org.nomadic121.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final @NonNull MessageService messageService;

    private final @NonNull AuthenticationService authenticationService;

    @MessageMapping("/message/{chatId}")
    public MessageForm getMessages(final Authentication authentication, final MessageForm messageForm,
                                   @DestinationVariable("chatId") Long chatId) {
        User user = authenticationService.getUserByAuthentication(authentication);
        messageService.saveAndDeliverMessage(user, chatId, messageForm);
        return messageForm;
    }

}
