package org.nomadic121.chat.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.form.MessageForm;

import java.util.List;

public interface MessageService {

    void save(Authentication authentication, Long chatId, MessageForm messageForm);

    void save(Authentication authentication, Chat chat, MessageForm messageForm);

    List<MessageDto> getAllMessages();

}
