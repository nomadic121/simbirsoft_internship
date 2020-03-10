package org.nomadic121.chat.service;

import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.form.ChatForm;

import java.security.Principal;
import java.util.List;

public interface ChatService {

    void save(Principal principal, ChatForm chatForm);

    List<ChatDto> getAllChats();

}
