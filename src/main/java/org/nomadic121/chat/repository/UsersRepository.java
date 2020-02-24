package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.User;

import java.util.List;

public interface UsersRepository {

    void add(User user);

    List<User> getAllUsers();

}
