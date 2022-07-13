package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import entities.*;
import edu.fudan.common.util.JsonUtils;

import java.util.UUID;


public class OrderRepositoryImpl implements OrderRepository {

    public RemoteCacheManager cacheManager;
    public RemoteCache<UUID, Order> cache;

    public OrderRepositoryImpl () {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer().host("10.97.152.242").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        cacheManager = new RemoteCacheManager(builder.build());
    }

    @Override
    public Order findById(UUID id) {
        cache = cacheManager.getCache("order-ispn");
        Order resOrder = cache.get(id);
        return resOrder;
    }

}
