package com.gisuni.hellospringbootjpa.servers;

import com.gisuni.hellospringbootjpa.model.User;

import java.util.List;

public interface UserRestServer {

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id ,User user);

    User getUser(Long id);

    List<User> getAll();
}
