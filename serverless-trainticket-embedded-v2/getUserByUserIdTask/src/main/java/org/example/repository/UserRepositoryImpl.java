package org.example.repository;

import org.example.entity.User;


import java.util.UUID;

import org.infinispan.Cache;
import org.infinispan.commons.api.CacheContainerAdmin;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;


public class UserRepositoryImpl implements UserRepository {

    public DefaultCacheManager cacheManager;
    public Cache<UUID, User> cache;
    public ConfigurationBuilder builder;

    public UserRepositoryImpl () {
       GlobalConfigurationBuilder global = GlobalConfigurationBuilder.defaultClusteredBuilder();

       cacheManager = new DefaultCacheManager(global.build());
       builder = new ConfigurationBuilder();
       builder.clustering().cacheMode(CacheMode.DIST_SYNC);
    }

    @Override
    public User findByUserId(UUID userId) {
        cache = cacheManager.administration().withFlags(CacheContainerAdmin.AdminFlag.VOLATILE)
                .getOrCreateCache("user-ispn", builder.build());

        User resUser = cache.get(userId);
        return resUser;

    }

}
