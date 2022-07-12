package com.openfaas.function.repository;


import entities.*;
import edu.fudan.common.util.JsonUtils;


import java.util.UUID;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

public class ContactsRepositoryImpl implements ContactsRepository {

    public RemoteCacheManager cacheManager;
    public RemoteCache<UUID, Contacts> cache;

    public ContactsRepositoryImpl () {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer().host("10.110.72.158").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        cacheManager = new RemoteCacheManager(builder.build());
    }

    @Override
    public Contacts findById(UUID id) {
        cache =cacheManager.getCache("contacts-ispn");
        Contacts resContact = cache.get(id);
        return resContact;
    }
}
