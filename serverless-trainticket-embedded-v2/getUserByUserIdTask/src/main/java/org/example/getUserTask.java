package org.example;

import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.infinispan.tasks.ServerTask;
import org.infinispan.tasks.TaskContext;

public class getUserTask implements ServerTask<String> {

    private TaskContext ctx;

    private UserService userService = new UserServiceImpl();

    @Override
    public void setTaskContext(TaskContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String call() throws Exception {
        String accountId = (String) ctx.getParameters().get().get("accountId");

        String userRes = userService.findByUserId(accountId);

        return userRes;
    }

    @Override
    public String getName() {
        return "get-user-by-userid";
    }

}