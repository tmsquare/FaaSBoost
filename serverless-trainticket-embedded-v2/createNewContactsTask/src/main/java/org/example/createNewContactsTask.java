package org.example;

import org.example.service.ContactsService;
import org.example.service.ContactsServiceImpl;
import org.infinispan.tasks.ServerTask;
import org.infinispan.tasks.TaskContext;

public class createNewContactsTask implements ServerTask<String> {

    private TaskContext ctx;

    private ContactsService contactsService = new ContactsServiceImpl();

    @Override
    public void setTaskContext(TaskContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String call() throws Exception {
        String addContact = (String) ctx.getParameters().get().get("contactString");

        String contactRes = contactsService.createContact(addContact);

        return contactRes;
    }

    @Override
    public String getName() {
        return "create-new-contact";
    }

}