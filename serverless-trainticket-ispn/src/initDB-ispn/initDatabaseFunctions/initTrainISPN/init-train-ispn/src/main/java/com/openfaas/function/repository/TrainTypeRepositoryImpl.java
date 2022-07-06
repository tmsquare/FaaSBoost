package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.TrainType;

import java.util.UUID;

public class TrainTypeRepositoryImpl implements TrainTypeRepository {

    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("train-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"train-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            TrainType info1 = new TrainType();
            info1.setId("GaoTieOne");
            info1.setConfortClass(Integer.MAX_VALUE);
            info1.setEconomyClass(Integer.MAX_VALUE);
            info1.setAverageSpeed(250);

            TrainType info2 = new TrainType();
            info2.setId("GaoTieTwo");
            info2.setConfortClass(Integer.MAX_VALUE);
            info2.setEconomyClass(Integer.MAX_VALUE);
            info2.setAverageSpeed(200);

            TrainType info3 = new TrainType();
            info3.setId("DongCheOne");
            info3.setConfortClass(Integer.MAX_VALUE);
            info3.setEconomyClass(Integer.MAX_VALUE);
            info3.setAverageSpeed(180);

            TrainType info4 = new TrainType();
            info4.setId("ZhiDa");
            info4.setConfortClass(Integer.MAX_VALUE);
            info4.setEconomyClass(Integer.MAX_VALUE);
            info4.setAverageSpeed(120);

            TrainType info5 = new TrainType();
            info5.setId("TeKuai");
            info5.setConfortClass(Integer.MAX_VALUE);
            info5.setEconomyClass(Integer.MAX_VALUE);
            info5.setAverageSpeed(120);

            TrainType info6 = new TrainType();
            info6.setId("KuaiSu");
            info6.setConfortClass(Integer.MAX_VALUE);
            info6.setEconomyClass(Integer.MAX_VALUE);
            info6.setAverageSpeed(90);

            RemoteCache<String, TrainType> cache = cacheManager.getCache("train-ispn");

            cache.put("GaoTieOne", info1);
            cache.put("GaoTieTwo", info2);
            cache.put("DongCheOne", info3);
            cache.put("ZhiDa", info4);
            cache.put("TeKuai", info5);
            cache.put("KuaiSu", info6);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
