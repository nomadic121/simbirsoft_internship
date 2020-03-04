package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Message, Long> {
}
