package com.openfaas.function.repository;


import entities.*;

import java.util.ArrayList;
import java.util.UUID;


public interface ContactsRepository {



    void save(Contacts contacts);
}
