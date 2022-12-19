package com.nhnacademy.domain;

import java.util.*;

public class Users implements UserRepository {

    private static Users instance = new Users();
    private Map<String, User> users = new HashMap<>();

    private Users() {}

    public static Users getInstance() {
        return instance;
    }

    @Override
    public void add(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {
        users.replace(user.getId(), user);
    }

    @Override
    public User remove(String id) {
        return users.remove(id);
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        for (User user: users.values()) {
            userList.add(user);
        }

        return userList;
    }
}
