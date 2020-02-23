package org.nomadic121.chat.services;

import org.nomadic121.chat.transfer.MessageDto;

import java.util.List;

public interface MessageService {

    void add(String message);

    List<MessageDto> getAllMessages ();

}
