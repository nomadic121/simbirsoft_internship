package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByUserName(String name);

    Optional<User> findOneByUserName(String name);

}
