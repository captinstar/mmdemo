package org.cssic.mmdemo.service;

import org.cssic.mmdemo.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Long id);
    boolean authenticate(String username, String password);
}
