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
    public User save(User user) {
        // 在实际项目中，这里应该对密码进行加密处理
        userDao.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        userDao.update(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = findByUsername(username);
        if (user == null || user.getPassword() == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}