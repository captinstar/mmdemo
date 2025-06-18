package org.cssic.mmdemo.dao;

import org.cssic.mmdemo.model.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Long id);
}