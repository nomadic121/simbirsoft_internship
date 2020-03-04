package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.entity.Chat;
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
    public void save(final Chat chat) {
        chatsRepository.save(chat);
    }

    @Override
    public List<ChatDto> getAllChats() {
        return chatsRepository.findAll().stream()
                .map(ChatMapper.INSTANCE::chatToChatDto)
                .collect(Collectors.toList());
    }

}
