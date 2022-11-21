package dev.akshith6212.blog.controller;

import dev.akshith6212.blog.models.User;
import dev.akshith6212.blog.service.PasswordService;
import dev.akshith6212.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordService passwordService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public ModelAndView main() {
        return login();
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute final User user) {
        System.out.println(user);
        ModelAndView loginView = new ModelAndView();
        loginView.setViewName("login");
        ModelAndView homeView = new ModelAndView();
        homeView.setViewName("home");
        User userOriginal = userService.findUserByUsername(user.getUsername());
        if (userOriginal == null)
            return loginView;
        if (userOriginal.getPassword().equals(passwordService.hashPassword(user.getPassword()))) {
//            user.
            return homeView;
        }
        return loginView;
    }

    @PostMapping("/register")
    public boolean register(@ModelAttribute final User user) {
        System.out.println(user);
        String hashPassword = passwordService.hashPassword(user.getPassword());
        user.setPassword(hashPassword);
        return userService.addUser(user);
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        return modelAndView;
    }
}
