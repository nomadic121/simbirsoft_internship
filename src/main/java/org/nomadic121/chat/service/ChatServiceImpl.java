package org.nomadic121.chat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.ChatForm;
import org.nomadic121.chat.mapper.ChatMapper;
import org.nomadic121.chat.repository.ChatsRepository;
import org.nomadic121.chat.repository.UsersRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final @NonNull ChatsRepository chatsRepository;

    private final @NonNull UsersRepository usersRepository;

    @Override
    public void save(final Principal principal, final ChatForm chatForm) {
        User creator = usersRepository.findByName(principal.getName());
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
