package com.openfaas.function.repository;


//import com.openfaas.function.entity.Route;
import entities.*;

import java.util.ArrayList;

import  java.util.UUID;

/**
 * @author fdse
 */
public interface RouteRepository {

    /**
     * find route by id
     *
     * @param id id
     * @return Route
     */
    RouteInfo findById(String id);

}
