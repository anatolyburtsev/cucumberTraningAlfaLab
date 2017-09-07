package ru.onotole.cucuEdu.cucuEduRest.entities;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Users {
    private Map<String, User> users;

    public Users() {
        users = new HashMap<>();
    }

    public void create(String username, Boolean vip, Integer sum) {
        users.put(username, new User(username, sum, vip));
    }

    public User get(String username) {
        return users.get(username);
    }
}
