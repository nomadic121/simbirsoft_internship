package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.mapper.MessageMapper;
import org.nomadic121.chat.repository.MessagesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final @NonNull MessagesRepository messagesRepository;

    @Override
    public void save(final Message message) {
        messagesRepository.save(message);
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return messagesRepository.findAll().stream()
                .map(MessageMapper.INSTANCE::messageToMessageDto)
                .collect(Collectors.toList());
    }

}