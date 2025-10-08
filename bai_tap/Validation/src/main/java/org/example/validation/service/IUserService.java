package org.example.validation.service;

import org.example.validation.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean save(User user);
}
