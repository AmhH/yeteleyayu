package com.logistics.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.logistics.exception.DataNotFoundException;
import com.logistics.model.Load;
import com.logistics.model.Location;
import com.logistics.model.Order;
import com.logistics.repository.LocationRepository;
import com.logistics.repository.OrderRepository;

import java.util.List;

public class LoadResolver implements GraphQLResolver<Load> {

    private LocationRepository locationRepository;
    private OrderRepository orderRepository;

    public LoadResolver(LocationRepository locationRepository, OrderRepository orderRepository) {
        this.locationRepository = locationRepository;
        this.orderRepository = orderRepository;
    }

    public Location getOrigin(Load load) {
        return locationRepository.findById(load.getOrigin().getId())
                .orElseThrow(() -> new DataNotFoundException(String.format("Origin location %d not found", load.getOrigin().getId()), load.getOrigin().getId()));
    }

    public Location getDestination(Load load) {
        return locationRepository.findById(load.getDestination().getId())
                .orElseThrow(() -> new DataNotFoundException(String.format("Destination location %d not found", load.getDestination().getId()), load.getOrigin().getId()));
    }

    public List<Order> getOrders(Load load) {
        return orderRepository.findByLoadId(load.getId());
    }
}
