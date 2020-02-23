package org.nomadic121.chat.services;

import org.nomadic121.chat.models.Message;
import org.nomadic121.chat.repositories.MessagesRepository;
import org.nomadic121.chat.transfer.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public void add(final String message) {
        messagesRepository.add(new Message(message));
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return null;
    }

}
