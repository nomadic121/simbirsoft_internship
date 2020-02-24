package org.nomadic121.chat.repository;

import org.nomadic121.chat.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UsersRepositoryImpl implements UsersRepository {

    private Set<User> users = new HashSet<>();

    @Override
    public void add(final User user) {
        users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
