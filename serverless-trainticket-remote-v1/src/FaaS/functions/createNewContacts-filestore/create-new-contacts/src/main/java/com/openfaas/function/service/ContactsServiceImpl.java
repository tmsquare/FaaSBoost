package com.openfaas.function.service;


import entities.*;
import com.openfaas.function.repository.ContactsRepositoryImpl;
import edu.fudan.common.util.mResponse;

import com.openfaas.function.repository.ContactsRepository;

import java.util.ArrayList;
import java.util.UUID;

public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository = new ContactsRepositoryImpl();

    String success = "Success";

//    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsServiceImpl.class);

    @Override
    public mResponse create(Contacts addContacts) {
        Contacts contacts = new Contacts();
        contacts.setId(UUID.randomUUID());
        contacts.setName(addContacts.getName());
        contacts.setPhoneNumber(addContacts.getPhoneNumber());
        contacts.setDocumentNumber(addContacts.getDocumentNumber());
        contacts.setAccountId(addContacts.getAccountId());
        contacts.setDocumentType(addContacts.getDocumentType());

        contactsRepository.save(contacts);

        return new mResponse<>(1, "Create contacts success", contacts);

    }

}


