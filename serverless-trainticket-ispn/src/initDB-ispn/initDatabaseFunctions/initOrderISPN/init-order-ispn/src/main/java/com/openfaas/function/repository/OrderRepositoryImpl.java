package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.Order;


import java.util.Date;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {

    private String accountId = "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f";
    private String contactName = "Contacts_One";
    private String contactDocumentNumber = "DocumentNumber_One";
    private String firstClass = "FirstClass-30";
    private String price = "100.0";

    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("order-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"order-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            Order order = new Order();
            order.setId(UUID.fromString("5ad7750b-a68b-49c0-a8c0-32776b067703"));
            order.setBoughtDate(new Date());
            order.setTravelDate(new Date("Sat Jul 29 00:00:00 GMT+0800 2017")); //NOSONAR
            order.setTravelTime(new Date("Mon May 04 09:02:00 GMT+0800 2013")); //NOSONAR
            order.setAccountId(UUID.fromString(accountId));
            order.setContactsName(contactName);
            order.setDocumentType(1);
            order.setContactsDocumentNumber(contactDocumentNumber);
            order.setTrainNumber("G1237");
            order.setCoachNumber(5);
            order.setSeatClass(2);
            order.setSeatNumber(firstClass);
            order.setFrom("nanjing");
            order.setTo("shanghaihongqiao");
            order.setStatus(0);
            order.setPrice(price);

            Order orderTwo = new Order();
            orderTwo.setId(UUID.fromString("8177ac5a-61ac-42f4-83f4-bd7b394d0531"));
            orderTwo.setBoughtDate(new Date());
            orderTwo.setTravelDate(new Date("Sat Jul 29 00:00:00 GMT+0800 2017")); //NOSONAR
            orderTwo.setTravelTime(new Date("Mon May 04 09:01:00 GMT+0800 2013")); //NOSONAR
            orderTwo.setAccountId(UUID.fromString(accountId));
            orderTwo.setContactsName(contactName);
            orderTwo.setDocumentType(1);
            orderTwo.setContactsDocumentNumber(contactDocumentNumber);
            orderTwo.setTrainNumber("G1234");
            orderTwo.setCoachNumber(5);
            orderTwo.setSeatClass(2);
            orderTwo.setSeatNumber(firstClass);
            orderTwo.setFrom("shanghai");
            orderTwo.setTo("beijing");
            orderTwo.setStatus(0);
            orderTwo.setPrice(price);


            Order orderThree = new Order();
            orderThree.setId(UUID.fromString("d3c91694-d5b8-424c-9974-e14c89226e49"));
            orderThree.setBoughtDate(new Date());
            orderThree.setTravelDate(new Date("Sat Jul 29 00:00:00 GMT+0800 2017")); //NOSONAR
            orderThree.setTravelTime(new Date("Mon May 04 09:00:00 GMT+0800 2013")); //NOSONAR
            orderThree.setAccountId(UUID.fromString(accountId));
            orderThree.setContactsName(contactName);
            orderThree.setDocumentType(1);
            orderThree.setContactsDocumentNumber(contactDocumentNumber);
            orderThree.setTrainNumber("G1235");
            orderThree.setCoachNumber(5);
            orderThree.setSeatClass(2);
            orderThree.setSeatNumber(firstClass);
            orderThree.setFrom("shanghai");
            orderThree.setTo("beijing");
            orderThree.setStatus(0);
            orderThree.setPrice(price);


            RemoteCache<UUID, Order> cache = cacheManager.getCache("order-ispn");

            cache.put(UUID.fromString("5ad7750b-a68b-49c0-a8c0-32776b067703"), order);
            cache.put(UUID.fromString("8177ac5a-61ac-42f4-83f4-bd7b394d0531"), orderTwo);
            cache.put(UUID.fromString("d3c91694-d5b8-424c-9974-e14c89226e49"), orderThree);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
