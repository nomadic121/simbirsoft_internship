package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class MessagesRepositoryImpl implements MessagesRepository {

    private List<Message> messages = new LinkedList<>();

    @Override
    public void add(final Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages);
    }

}
