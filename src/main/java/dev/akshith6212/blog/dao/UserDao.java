package dev.akshith6212.blog.dao;

import dev.akshith6212.blog.models.User;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);
}
