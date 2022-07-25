package com.openfaas.function.repository;

import entities.User;
import edu.fudan.common.util.JsonUtils;


import java.util.UUID;


import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;



public class UserRepositoryImpl implements UserRepository {

    public RemoteCacheManager cacheManager;
    public RemoteCache<UUID, User> cache;

    public UserRepositoryImpl () {
       ConfigurationBuilder builder = new ConfigurationBuilder();
       builder.addServer().host("10.98.216.80").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

       LibraryInitializer initializer = new LibraryInitializerImpl();
       builder.addContextInitializer(initializer);

       cacheManager = new RemoteCacheManager(builder.build());
    }

    @Override
    public User findByUserId(UUID userId) {
        cache =cacheManager.getCache("user-ispn");
        User resUser = cache.get(userId);
        return resUser;

    }

}
