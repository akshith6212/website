package dev.akshith6212.blog.controller;

import dev.akshith6212.blog.service.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @Autowired
    PasswordService passwordService;

    private final static Logger logger = LoggerFactory.getLogger(PasswordController.class);

    @GetMapping("/hash")
    @ResponseBody
    public String hashPassword(@RequestParam String rawPassword) {
        logger.info(rawPassword);
        return passwordService.hashPassword(rawPassword);
    }
}
