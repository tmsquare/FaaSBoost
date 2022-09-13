package com.openfaas.function;

import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


import java.util.Map;
import java.util.HashMap;

public class Handler extends com.openfaas.model.AbstractHandler  {


    public IResponse Handle(IRequest req) {

        String accountId = req.getPath().get("accountId");

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer().host("10.100.225.11").port(11222);

        RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());

        RemoteCache<String, String> cache = cacheManager.getCache("user-ispn");

        Map<String, byte[]> parameters = new HashMap<>();
        parameters.put("accountId", accountId.getBytes());

        byte [] userByte = cache.execute("get-user-by-userid", parameters);

        mResponse mRes = new mResponse<>(0, "No User", null);

        if (userByte != null) {
           mRes = new mResponse<>(1, "Find User Success", new String(userByte));
        }

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));
        return res;
    }
}
