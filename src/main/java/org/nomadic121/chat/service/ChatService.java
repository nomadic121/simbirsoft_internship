package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.entity.User;
import org.nomadic121.chat.form.ChatForm;

import java.util.List;

public interface ChatService {

    void createAndSave(User user, ChatForm chatForm);

    List<ChatDto> getAllChats();

    ChatDto getOneById(Long id);

    void deleteById(Long id);

    void updateById(Long id, ChatForm chatForm);

}
