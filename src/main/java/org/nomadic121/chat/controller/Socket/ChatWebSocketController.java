package org.nomadic121.chat.controller.Socket;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final @NonNull MessageService messageService;

    @MessageMapping("/message/{chatId}")
//    @SendTo("/chat/messages")
    public MessageForm getMessages(final Principal principal, final MessageForm messageForm, @DestinationVariable("chatId") Long chatId) throws Exception {
        messageService.saveAndDeliverMessage(principal, chatId, messageForm);
        return messageForm;
    }

}
