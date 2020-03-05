package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.entity.Message;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.MessageForm;
import org.nomadic121.chat.mapper.MessageMapper;
import org.nomadic121.chat.repository.ChatsRepository;
import org.nomadic121.chat.repository.MessagesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final @NonNull MessagesRepository messagesRepository;

    private final @NonNull ChatsRepository chatsRepository;

    @Override
    public List<MessageDto> getAllMessages() {
        return messagesRepository.findAll().stream()
                .map(MessageMapper.INSTANCE::messageToMessageDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(final Authentication authentication, final Long chatId, final MessageForm messageForm) {
        Chat chat = chatsRepository.findById(chatId).get();
        save(authentication, chat, messageForm);
    }

    @Override
    public void save(final Authentication authentication, final Chat chat, final MessageForm messageForm) {
        User author = null; //TODO get user by auth
        Message msg = Message.builder()
                .author(author)
                .chat(chat)
                .text(messageForm.getMessage())
                .build();
        messagesRepository.save(msg);
    }

}