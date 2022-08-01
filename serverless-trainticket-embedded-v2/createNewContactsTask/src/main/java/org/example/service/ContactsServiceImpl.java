package org.example.service;

import org.example.repository.ContactsRepositoryImpl;

import org.example.entity.Contacts;
import org.example.repository.ContactsRepository;

import com.google.gson.Gson;

import java.util.UUID;

/**
 * @author fdse
 */

public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository = new ContactsRepositoryImpl();

    @Override
    public String createContact(String addContacts) {

        Gson gson = new Gson();
        Contacts contacts = gson.fromJson(addContacts, Contacts.class);

        contactsRepository.save(contacts);

        return "Success! Contact created.";

    }

}
