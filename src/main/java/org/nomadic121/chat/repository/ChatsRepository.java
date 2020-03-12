package org.nomadic121.chat.repository;

import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Chat;
import org.nomadic121.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatsRepository extends JpaRepository<Chat, Long> {
}
