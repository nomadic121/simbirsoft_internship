package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.Message;

import java.util.List;

public interface MessagesRepository {

    void add(Message message);

    List<Message> getAllMessages();

}
