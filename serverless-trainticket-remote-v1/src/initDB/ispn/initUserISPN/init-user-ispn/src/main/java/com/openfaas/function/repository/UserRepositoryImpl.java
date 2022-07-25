package com.openfaas.function.repository;


import com.openfaas.function.entity.User;

import java.util.UUID;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;


public class UserRepositoryImpl implements UserRepository {

    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.98.216.80")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);


        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("user-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"user-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {


            User user = new User(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"),
                    "fdse_microservice",
                    "111111",
                    1,
                    1,
                    "2135488099312X",
                    "fdse_microservice@163.com"
            );

            RemoteCache<UUID, User> cache = cacheManager.getCache("user-ispn");

            cache.put(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"), user);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
