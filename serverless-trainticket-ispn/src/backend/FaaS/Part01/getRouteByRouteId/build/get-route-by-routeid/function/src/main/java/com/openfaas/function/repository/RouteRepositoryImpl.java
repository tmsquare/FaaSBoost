package com.openfaas.function.repository;


import entities.*;
import edu.fudan.common.util.JsonUtils;


import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import java.util.UUID;

public class RouteRepositoryImpl implements RouteRepository {

    public RemoteCacheManager cacheManager;
    public RemoteCache<UUID, RouteInfo> cache;

    public RouteRepositoryImpl () {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer().host("10.97.152.242").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        cacheManager = new RemoteCacheManager(builder.build());
    }

    @Override
    public RouteInfo findById(String routeId) {
        cache =cacheManager.getCache("route-ispn");
        RouteInfo resRoute = cache.get(UUID.fromString(routeId));
        return resRoute;
    }
}
