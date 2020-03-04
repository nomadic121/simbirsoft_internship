package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatsRepository extends JpaRepository<Chat, Long> {
}
