package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
//import com.openfaas.function.entity.*;
import entities.*;

/**
 * @author fdse
 */
public interface OrderService {

    mResponse getOrderById(String orderId );

}
