package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.mapper.MessageMapper;
import org.nomadic121.chat.mapper.UserMapper;
import org.nomadic121.chat.repository.ChatsRepository;
import org.nomadic121.chat.repository.MessagesRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final @NonNull MessagesRepository messagesRepository;

    private final @NonNull ChatsRepository chatsRepository;

    private final @NonNull SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void saveAndDeliverMessage(final User user, final Long chatId, final MessageForm messageForm) {
        save(user, chatId, messageForm);
        simpMessagingTemplate.convertAndSend("/chat/messages/" + chatId, messageForm);
    }

    private void save(final User user, final Long chatId, final MessageForm messageForm) {
        Chat chat = chatsRepository.findById(chatId).orElseThrow(() -> new EmptyResultDataAccessException("Chat not found", 1));
        Message msg = Message.builder()
                .author(user)
                .chat(chat)
                .text(messageForm.getMessage())
                .build();
        messagesRepository.save(msg);
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return messagesRepository.findAll().stream()
                .map(MessageMapper.INSTANCE::messageToMessageDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageDto> getMessagesByChatId(final Long id) {
        Chat chat = chatsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Chat not found", 1));
        return messagesRepository.findAllByChat(chat).stream()
                .map(MessageMapper.INSTANCE::messageToMessageDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto getOneById(final Long id) {
        Message message = messagesRepository.getOne(id);
        return MessageMapper.INSTANCE.messageToMessageDto(message);
    }
}