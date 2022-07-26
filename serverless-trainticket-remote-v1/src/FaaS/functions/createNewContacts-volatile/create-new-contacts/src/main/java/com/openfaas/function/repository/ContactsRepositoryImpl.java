package com.openfaas.function.repository;

import entities.Contacts;
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
        builder.addServer().host("10.98.216.80").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        cacheManager = new RemoteCacheManager(builder.build());
    }

    @Override
    public void save(Contacts contacts) {
        cache =cacheManager.getCache("contacts-ispn");
        cache.put(contacts.getId(), contacts);
    }
}
