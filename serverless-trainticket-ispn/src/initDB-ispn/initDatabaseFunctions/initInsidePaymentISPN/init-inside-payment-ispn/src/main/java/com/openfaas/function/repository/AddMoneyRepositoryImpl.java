package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import java.util.UUID;

import com.openfaas.function.entity.AccountInfo;
import com.openfaas.function.entity.Money;
import com.openfaas.function.entity.MoneyType;
import edu.fudan.common.util.JsonUtils;
//import org.bson.Document;

public class AddMoneyRepositoryImpl implements AddMoneyRepository {


    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.97.152.242")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("account-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"account-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            AccountInfo info1 = new AccountInfo();
            info1.setUserId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");
            info1.setMoney("10000");

            Money addMoney = new Money();
            addMoney.setMoney(info1.getMoney());
            addMoney.setUserId(info1.getUserId());
            addMoney.setType(MoneyType.A);

            RemoteCache<UUID, Money> cache = cacheManager.getCache("account-ispn");

            cache.put(UUID.fromString(info1.getUserId()), addMoney);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }



}
