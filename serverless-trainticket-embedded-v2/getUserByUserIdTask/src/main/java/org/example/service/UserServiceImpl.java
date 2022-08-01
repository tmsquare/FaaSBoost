package org.example.service;

import org.example.repository.UserRepositoryImpl;

import org.example.entity.User;
import org.example.repository.UserRepository;

import com.google.gson.Gson;

import java.util.UUID;

/**
 * @author fdse
 */

public class UserServiceImpl implements UserService {
    private UserRepository userRepository=new UserRepositoryImpl();

    @Override
    public String findByUserId(String userId) {

        User user = userRepository.findByUserId(UUID.fromString(userId));
        if (user != null) {
            //return user.toString();
            return new Gson().toJson(user);
        }
        return "User not found";
    }

}
