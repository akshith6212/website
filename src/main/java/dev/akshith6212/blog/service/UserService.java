package dev.akshith6212.blog.service;

import dev.akshith6212.blog.dao.UserDao;
import dev.akshith6212.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUser(Integer id) {
        Optional<User> user = userDao.findById(id);
        if (user.isEmpty())
            return null;
        return user.get();
    }

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public boolean addUser(User user) {
        userDao.save(user);
        return findUser(user.getId()) != null;
    }
}
