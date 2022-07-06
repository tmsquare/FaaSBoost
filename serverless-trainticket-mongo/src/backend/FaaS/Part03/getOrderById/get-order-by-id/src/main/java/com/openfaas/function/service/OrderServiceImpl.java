package com.openfaas.function.service;

import com.openfaas.function.repository.OrderRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import com.openfaas.function.repository.OrderRepository;

import java.util.*;

/**
 * @author fdse
 */
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository=new OrderRepositoryImpl();


//    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    String success = "Success";
    String orderNotFound = "Order Not Found";



    @Override
    public mResponse getOrderById(String orderId) {
        Order order = orderRepository.findById(UUID.fromString(orderId));
        if (order == null) {
            return new mResponse<>(0, orderNotFound, null);
        } else {
            return new mResponse<>(1, "Success.", order);
        }
    }

}

