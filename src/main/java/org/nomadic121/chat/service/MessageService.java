package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.form.MessageForm;

import java.security.Principal;
import java.util.List;

public interface MessageService {

    void save(Principal principal, Long chatId, MessageForm messageForm);

    void save(Principal principal, Chat chat, MessageForm messageForm);

    void saveAndDeliverMessage(Principal principal, Long chatId,  MessageForm messageForm);

    List<MessageDto> getAllMessages();

}
