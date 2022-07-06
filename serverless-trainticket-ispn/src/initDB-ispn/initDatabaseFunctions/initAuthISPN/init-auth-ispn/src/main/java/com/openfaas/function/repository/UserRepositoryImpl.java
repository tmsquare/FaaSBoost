package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.User;
import edu.fudan.common.util.JsonUtils;


import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("auth-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"auth-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            User user1 = new User(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"),
                    "fdse_microservice",
                    "111111",
                    new HashSet<>(Arrays.asList("ROLE_USER"))
            );

            User user2 = new User(UUID.fromString("5d2a46c7-71cb-5cf1-b5bb-b68406d9da6a"),
                    "admin",
                    "222222",
                    new HashSet<>(Arrays.asList("ROLE_ADMIN"))
            );

            RemoteCache<UUID, User> cache = cacheManager.getCache("auth-ispn");

            cache.put(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"), user1);
            cache.put(UUID.fromString("5d2a46c7-71cb-5cf1-b5bb-b68406d9da8a"), user2);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

}
