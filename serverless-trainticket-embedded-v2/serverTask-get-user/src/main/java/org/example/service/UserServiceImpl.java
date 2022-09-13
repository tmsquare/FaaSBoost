package org.example.service;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.repository.UserRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository=new UserRepositoryImpl();

    @Override
    public User findByUserId(String userId) {

        User user = userRepository.findByUserId(UUID.fromString(userId));
        if (user != null) {
            return user;
        }
        return null;
    }

}