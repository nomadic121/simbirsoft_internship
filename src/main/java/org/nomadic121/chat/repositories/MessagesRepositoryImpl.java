package org.nomadic121.chat.repositories;

import org.nomadic121.chat.models.Message;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessagesRepositoryImpl  implements MessagesRepository{

    private List<Message> messages = new LinkedList<>();

    @Override
    public void add(final Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messages.stream().collect(Collectors.toList());
    }

}
