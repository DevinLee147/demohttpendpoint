package com.example.demohttpendpoint.service;

import com.example.demohttpendpoint.model.User;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    /*
    10,000 concurrent write requests with a 10:1 ratio of read to write operations.
    Unit test performance shows that ConcurrentHashMap performs better than the read-write lock
     */
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public User createUser(User user) {
        if (users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        users.put(user.getUsername(), user);
        return user;
    }
}

