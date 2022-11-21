package dev.akshith6212.blog.controller;

import dev.akshith6212.blog.models.User;
import dev.akshith6212.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UserService userService;

    @GetMapping("/adduser")
    public boolean addUser(User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody final User user) {
        return userService.addUser(user);
    }

    @GetMapping("/addusers")
    @ResponseBody
    public boolean addUsers(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String password) {
        User user = new User(username, firstname, lastname, password);
        return userService.addUser(user);
    }
}
