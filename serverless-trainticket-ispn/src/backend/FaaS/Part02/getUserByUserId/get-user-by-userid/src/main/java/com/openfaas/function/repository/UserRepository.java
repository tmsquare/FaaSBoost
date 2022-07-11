package com.openfaas.function.repository;

import entities.User;

import java.util.UUID;
import org.infinispan.client.hotrod.RemoteCache;

public interface UserRepository {


    User findByUserId(UUID userId);
}
