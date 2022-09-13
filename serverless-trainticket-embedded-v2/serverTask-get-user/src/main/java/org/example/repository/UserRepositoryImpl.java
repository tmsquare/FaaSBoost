package org.example.repository;

import org.example.entity.User;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;

import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    public RemoteCacheManager cacheManager;
    public RemoteCache<UUID, User> cache;

    public UserRepositoryImpl () {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer().host("127.0.0.1").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        cacheManager = new RemoteCacheManager(builder.build());
    }

    @Override
    public User findByUserId(UUID userId) {
        cache = cacheManager.getCache("user-ispn");
        User resUser = cache.get(userId);
        return resUser;

    }
}
