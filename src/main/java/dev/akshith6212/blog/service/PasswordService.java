package dev.akshith6212.blog.service;

import dev.akshith6212.blog.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(PasswordService.class);

    public String hashPassword(String rawPassword) {
        logger.info(rawPassword);
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    public boolean checkPassword(Integer userId, String password) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(userService.findUser(userId).getPassword());
    }
}
