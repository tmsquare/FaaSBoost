package com.openfaas.function;

import com.openfaas.function.service.RouteService;
import com.openfaas.function.service.RouteServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


public class Handler extends com.openfaas.model.AbstractHandler  {
    private RouteService routeService = new RouteServiceImpl();

    public IResponse Handle(IRequest req) {
        String routeId = req.getPath().get("routeId");

        mResponse mRes = routeService.getRouteById(routeId);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
