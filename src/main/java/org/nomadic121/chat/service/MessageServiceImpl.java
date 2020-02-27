package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.mapper.MessageMapper;
import org.nomadic121.chat.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessagesRepository messagesRepo;

    @Override
    public void add(final Message message) {
        messagesRepo.add(message);
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return messagesRepo.getAllMessages().stream()
                .map(MessageMapper.INSTANCE::messageToMessageDto)
                .collect(Collectors.toList());
    }

}