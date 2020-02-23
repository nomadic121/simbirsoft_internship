package org.nomadic121.chat.repositories;

import org.nomadic121.chat.models.User;

import java.util.List;

public interface UsersRepository {

    void add (User user);

    List<User> getAllUsers ();

}
