package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.entity.Chat;

import java.util.List;

public interface ChatService {

    void save(Chat chat);

    List<ChatDto> getAllChats();

}
