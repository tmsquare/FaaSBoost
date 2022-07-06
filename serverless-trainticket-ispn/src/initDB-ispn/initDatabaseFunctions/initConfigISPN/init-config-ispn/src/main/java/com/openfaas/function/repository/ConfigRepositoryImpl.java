package com.openfaas.function.repository;
import com.openfaas.function.entity.*;
import edu.fudan.common.util.JsonUtils;

import java.util.UUID;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;


public class ConfigRepositoryImpl implements ConfigRepository {

    @Override
    public boolean init(){

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);


        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("config-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"config-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {


            Config config = new Config();

            config.setName("DirectTicketAllocationProportion");
            config.setValue("0.5");
            config.setDescription("Allocation Proportion Of The Direct Ticket - From Start To End");

            RemoteCache<UUID, Config> cache = cacheManager.getCache("config-ispn");

            cache.put(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"), config);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
