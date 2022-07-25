package com.openfaas.function.repository;

import com.openfaas.function.entity.Contacts;
import com.openfaas.function.entity.DocumentType;
import edu.fudan.common.util.JsonUtils;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import java.util.UUID;

public class ContactsRepositoryImpl implements ContactsRepository {

    @Override
    public boolean init(){
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.98.216.80")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("contacts-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"contacts-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            Contacts contactsOne = new Contacts();
            contactsOne.setAccountId(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"));
            contactsOne.setDocumentType(DocumentType.ID_CARD.getCode());
            contactsOne.setName("Contacts_One");
            contactsOne.setDocumentNumber("DocumentNumber_One");
            contactsOne.setPhoneNumber("ContactsPhoneNum_One");
            contactsOne.setId(UUID.fromString("90d357c6-b31e-49b8-8b1e-f33f5e51ccef"));

            Contacts contactsTwo = new Contacts();
            contactsTwo.setAccountId(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"));
            contactsTwo.setDocumentType(DocumentType.ID_CARD.getCode());
            contactsTwo.setName("Contacts_Two");
            contactsTwo.setDocumentNumber("DocumentNumber_Two");
            contactsTwo.setPhoneNumber("ContactsPhoneNum_Two");
            contactsTwo.setId(UUID.fromString("9e0b2927-67fa-4bd1-8198-cdad5c762289"));

            RemoteCache<UUID, Contacts> cache = cacheManager.getCache("contacts-ispn");

            cache.put(UUID.fromString("90d357c6-b31e-49b8-8b1e-f33f5e51ccef"), contactsOne);
            cache.put(UUID.fromString("9e0b2927-67fa-4bd1-8198-cdad5c762289"), contactsTwo);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
