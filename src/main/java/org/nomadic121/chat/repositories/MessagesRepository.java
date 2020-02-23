package org.nomadic121.chat.repositories;

import org.nomadic121.chat.models.Message;

import java.util.List;

public interface MessagesRepository {

    void add(Message message);

    List<Message> getAllMessages ();

}
