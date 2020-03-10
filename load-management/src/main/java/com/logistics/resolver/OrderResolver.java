package com.logistics.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.logistics.exception.DataNotFoundException;
import com.logistics.model.Location;
import com.logistics.model.Order;
import com.logistics.repository.LocationRepository;

public class OrderResolver implements GraphQLResolver<Order> {
    private LocationRepository locationRepository;

    public OrderResolver(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location getpickUpStop(Order order) {
        return locationRepository.findById(order.getPickUpStop()
                .getId())
                .orElseThrow(() -> new DataNotFoundException(String.format("Pickup location %d not found", order.getPickUpStop().getId()),order.getPickUpStop().getId()));
    }

    public Location getDeliveryStop(Order order) {
        return locationRepository.findById(order.getDeliveryStop()
                .getId())
                .orElseThrow(() -> new DataNotFoundException(String.format("Delivery location %d not found", order.getPickUpStop().getId()),order.getPickUpStop().getId()));
    }

    public Long getLoadId(Order order){
        return order.getLoad().getId();
    }
}
