package org.example;

import org.example.entity.User;
import org.example.repository.LibraryInitializer;
import org.example.repository.LibraryInitializerImpl;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.tasks.ServerTask;
import org.infinispan.tasks.TaskContext;

import java.util.UUID;

public class getUserTask implements ServerTask<byte[]> {

    private TaskContext ctx;

    @Override
    public void setTaskContext(TaskContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public byte[] call() throws Exception {
        byte[] name = (byte[]) ctx.getParameters().get().get("accountId");

        UserService service = new UserServiceImpl();
        User userRes = service.findByUserId(new String(name));

        if (userRes != null) {
            return userRes.toString().getBytes();
        }
        return null;
    }

    @Override
    public String getName() {
        return "get-user-by-userid";
    }

}