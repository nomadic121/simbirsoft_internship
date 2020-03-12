package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.MessageForm;

import java.util.List;

public interface MessageService {

    void saveAndDeliverMessage(User user, Long chatId, MessageForm messageForm);

    List<MessageDto> getAllMessages();

    List<MessageDto> getMessagesByChatId(Long id);

    MessageDto getOneById(Long id);

}
