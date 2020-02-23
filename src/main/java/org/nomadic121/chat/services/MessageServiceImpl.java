package org.nomadic121.chat.services;

import org.nomadic121.chat.models.Message;
import org.nomadic121.chat.repositories.MessagesRepository;
import org.nomadic121.chat.transfer.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessagesRepository messagesRepo;

    @Override
    public void add(final String message) {
        messagesRepo.add(new Message(message));
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return MessageDto.from(messagesRepo.getAllMessages());
    }

}