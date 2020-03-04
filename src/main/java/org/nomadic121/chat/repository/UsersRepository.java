package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
