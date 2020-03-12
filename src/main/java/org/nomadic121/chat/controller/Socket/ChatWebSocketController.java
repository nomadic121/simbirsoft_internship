package org.nomadic121.chat.controller.Socket;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final @NonNull MessageService messageService;

    @MessageMapping("/message/{chatId}")
    public MessageForm getMessages(final Authentication authentication, final MessageForm messageForm,
                                   @DestinationVariable("chatId") Long chatId) {
        messageService.saveAndDeliverMessage(authentication, chatId, messageForm);
        return messageForm;
    }

}
