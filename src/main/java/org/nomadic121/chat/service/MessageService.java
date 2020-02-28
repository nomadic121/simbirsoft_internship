package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Message;

import java.util.List;

public interface MessageService {

    void save(Message message);

    List<MessageDto> getAllMessages();

}
