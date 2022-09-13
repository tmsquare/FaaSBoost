package org.example.repository;


import org.example.entity.User;

import java.util.UUID;

public interface UserRepository {


    User findByUserId(UUID userId);
}
