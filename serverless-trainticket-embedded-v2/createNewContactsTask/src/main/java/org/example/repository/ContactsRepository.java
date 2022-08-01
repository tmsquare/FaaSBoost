package org.example.repository;

import org.example.entity.Contacts;

import java.util.UUID;

public interface ContactsRepository {

    void save(Contacts contacts);
}
