package com.logistics.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.logistics.model.Load;
import com.logistics.model.Location;
import com.logistics.model.Order;
import com.logistics.repository.LoadRepository;
import com.logistics.repository.LocationRepository;
import com.logistics.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Query implements GraphQLQueryResolver {

    private LocationRepository locationRepository;
    private OrderRepository orderRepository;
    private LoadRepository loadRepository;

    @Autowired
    public Query(LocationRepository locationRepository, OrderRepository orderRepository, LoadRepository loadRepository) {
        this.locationRepository = locationRepository;
        this.orderRepository = orderRepository;
        this.loadRepository = loadRepository;
    }


    public Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
    }

    public Iterable<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Iterable<Load> findAllLoads() {
        return loadRepository.findAll();
    }

    public long countLoads() {
        return loadRepository.count();
    }

    public long countOrders() {
        return orderRepository.count();
    }

    public long countLocations() {
        return locationRepository.count();
    }
}
