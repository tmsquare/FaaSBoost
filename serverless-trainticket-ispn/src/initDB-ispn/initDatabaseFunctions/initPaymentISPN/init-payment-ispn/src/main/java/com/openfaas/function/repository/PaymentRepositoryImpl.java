package com.openfaas.function.repository;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.Payment;
import java.util.UUID;


public class PaymentRepositoryImpl implements PaymentRepository {

    @Override
    public boolean init(){

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.97.152.242")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("payment-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"payment-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            Payment payment = new Payment();
            payment.setId("5ad7750b-a68b-49c0-a8c0-35276b067701");
            payment.setOrderId("5ad7750b-a68b-49c0-a8c0-32776b067701");
            payment.setPrice("10000.0");
            payment.setUserId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");

            RemoteCache<UUID, Payment> cache = cacheManager.getCache("payment-ispn");

            cache.put(UUID.fromString("5ad7750b-a68b-49c0-a8c0-35276b067701"), payment);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
