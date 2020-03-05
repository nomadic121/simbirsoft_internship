package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.ChatForm;
import org.nomadic121.chat.mapper.ChatMapper;
import org.nomadic121.chat.repository.ChatsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final @NonNull ChatsRepository chatsRepository;

    @Override
    public void save(final Authentication authentication, final ChatForm chatForm) {
        User creator = null; //TODO get user by auth
        Chat chat = Chat.builder()
                .creator(creator)
                .title(chatForm.getTitle())
                .build();
        chatsRepository.save(chat);
    }

    @Override
    public List<ChatDto> getAllChats() {
        return chatsRepository.findAll().stream()
                .map(ChatMapper.INSTANCE::chatToChatDto)
                .collect(Collectors.toList());
    }

}
