package com.openfaas.function.service;

import entities.*;
import edu.fudan.common.util.mResponse;

import java.util.UUID;

/**
 * @author fdse
 */
public interface ContactsService {

    /**
     * create
     *
     * @param addContacts add contacts
     * @return Reaponse
     */
    mResponse create(Contacts addContacts);

}
