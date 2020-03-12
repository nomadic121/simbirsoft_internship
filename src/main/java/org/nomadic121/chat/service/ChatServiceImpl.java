package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
    public void createAndSave(final User user, final ChatForm chatForm) {
        Chat chat = Chat.builder()
                .creator(user)
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

    @Override
    public ChatDto getOneById(final Long id) {
        Chat chat = chatsRepository.getOne(id);
        return ChatMapper.INSTANCE.chatToChatDto(chat);
    }

}
