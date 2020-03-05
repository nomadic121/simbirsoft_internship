package org.nomadic121.chat.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.form.ChatForm;

import java.util.List;

public interface ChatService {

    void save(Authentication authentication, ChatForm chatForm);

    List<ChatDto> getAllChats();

}
