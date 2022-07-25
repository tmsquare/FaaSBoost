package com.openfaas.function;

import com.openfaas.function.entity.User;
import com.openfaas.function.service.UserService;
import com.openfaas.function.service.UserServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


public class Handler extends com.openfaas.model.AbstractHandler  {

    private UserService userService = new UserServiceImpl();

    public IResponse Handle(IRequest req) {

        User user =  new User();
        mResponse mRes = new mResponse<>(0, "Null User", user);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
