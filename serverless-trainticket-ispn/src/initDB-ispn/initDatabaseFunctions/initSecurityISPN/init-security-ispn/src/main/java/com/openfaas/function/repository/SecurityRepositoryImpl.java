package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import java.util.UUID;

import com.openfaas.function.entity.SecurityConfig;

public class SecurityRepositoryImpl implements SecurityRepository {

    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("security-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"security-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            SecurityConfig info1 = new SecurityConfig();
            info1.setName("max_order_1_hour");
            info1.setValue(Integer.MAX_VALUE + "");
            info1.setDescription("Max in 1 hour");

            SecurityConfig info2 = new SecurityConfig();
            info2.setName("max_order_not_use");
            info2.setValue(Integer.MAX_VALUE + "");
            info2.setDescription("Max not used");


            RemoteCache<UUID, SecurityConfig> cache = cacheManager.getCache("security-ispn");

            cache.put(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"), info1);
            cache.put(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6a"), info2);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
