package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.MessageDto;

import java.util.List;

public interface MessageService {

    void add(String message);

    List<MessageDto> getAllMessages();

}
