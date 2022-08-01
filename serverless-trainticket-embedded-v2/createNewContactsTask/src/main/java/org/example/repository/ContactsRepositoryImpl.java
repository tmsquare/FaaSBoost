package org.example.repository;

import org.example.entity.Contacts;


import java.util.UUID;

import org.infinispan.Cache;
import org.infinispan.commons.api.CacheContainerAdmin;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;


public class ContactsRepositoryImpl implements ContactsRepository {

    public DefaultCacheManager cacheManager;
    public Cache<UUID, Contacts> cache;
    public ConfigurationBuilder builder;

    public ContactsRepositoryImpl() {
       GlobalConfigurationBuilder global = GlobalConfigurationBuilder.defaultClusteredBuilder();

       cacheManager = new DefaultCacheManager(global.build());
       builder = new ConfigurationBuilder();
       builder.clustering().cacheMode(CacheMode.DIST_SYNC);
    }

    @Override
    public void save(Contacts contacts) {
        cache = cacheManager.administration().withFlags(CacheContainerAdmin.AdminFlag.VOLATILE)
                .getOrCreateCache("contacts-ispn", builder.build());

        cache.put(contacts.getId(), contacts);

    }

}
