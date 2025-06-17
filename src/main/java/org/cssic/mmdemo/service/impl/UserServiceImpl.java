package org.cssic.mmdemo.service.impl;

import org.cssic.mmdemo.dao.UserDao;
import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        // 在实际项目中，这里应该对密码进行加密处理
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null) {
            // 在实际项目中，这里应该对密码进行加密比对
            return user.getPassword().equals(password) && user.isActive();
        }
        return false;
    }
}
