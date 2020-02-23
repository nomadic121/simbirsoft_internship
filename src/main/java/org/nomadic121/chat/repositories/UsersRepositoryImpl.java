package org.nomadic121.chat.repositories;

import org.nomadic121.chat.models.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsersRepositoryImpl implements UsersRepository {

    private Set<User> users = new HashSet<>();

    @Override
    public void add(final User user) {
        users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users.stream().collect(Collectors.toList());
    }

}
