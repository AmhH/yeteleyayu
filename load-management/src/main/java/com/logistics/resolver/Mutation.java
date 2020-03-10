package com.logistics.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.logistics.exception.DataNotFoundException;
import com.logistics.model.Load;
import com.logistics.model.Location;
import com.logistics.model.Order;
import com.logistics.publisher.LocationPublisher;
import com.logistics.repository.LoadRepository;
import com.logistics.repository.LocationRepository;
import com.logistics.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Transactional
public class Mutation implements GraphQLMutationResolver {

    @PersistenceContext
    private EntityManager entityManager;

    private LocationRepository locationRepository;
    private OrderRepository orderRepository;
    private LoadRepository loadRepository;
    private LocationPublisher publisher;

    @Autowired
    public Mutation(LocationRepository locationRepository, OrderRepository orderRepository, LoadRepository loadRepository,
                    LocationPublisher publisher) {
        this.locationRepository = locationRepository;
        this.orderRepository = orderRepository;
        this.loadRepository = loadRepository;
        this.publisher = publisher;
    }

    /**
     * Creates a new location
     *
     * @param city
     * @param state
     * @param zipCode
     * @return Location
     */
    public Location newLocation(String city, String state, String zipCode) {
        Location location = new Location(city, state, zipCode);
        Location newLocation = locationRepository.save(location);
        publisher.publish(newLocation);
        return newLocation;
    }

    /**
     * Updates a location
     *
     * @param id
     * @param city
     * @param state
     * @param zipCode
     * @return Location
     */
    public Location updateLocation(Long id, String city, String state, String zipCode) {
        Optional<Location> location = locationRepository.findById(id);

        if (location.isEmpty())
            throw new DataNotFoundException("Location %d not found", id);

        Location locations = location.get();
        locations.setCity(city);
        locations.setState(state);
        locations.setZipCode(zipCode);

        return locationRepository.save(locations);
    }

    /**
     * Deletes a location
     *
     * @param city
     * @return boolean
     */
    public boolean deleteLocation(String city) {
        return locationRepository.deleteByCity(city) > 0;
    }


    public Order newOrder(LocalDateTime pickUpDateTime,
                          LocalDateTime deliveryDateTime,
                          Long pickUpStopId,
                          Long deliveryStopId,
                          boolean hazmat) {
        Order order = new Order(
                OffsetDateTime.of(pickUpDateTime, ZoneOffset.UTC),
                hazmat,
                OffsetDateTime.of(deliveryDateTime, ZoneOffset.UTC)
        );

        Location pickUpLocation = entityManager.getReference(Location.class, pickUpStopId);
        Location deliveryLocation = entityManager.getReference(Location.class, deliveryStopId);

        order.setPickUpStop(pickUpLocation);
        order.setDeliveryStop(deliveryLocation);

        return orderRepository.save(order);
    }

    /**
     *
     * @param id
     * @param pickUpDateTime
     * @param deliveryDateTime
     * @param pickUpStopId
     * @param deliveryStopId
     * @param hazmat
     * @param loadId
     * @return Order
     */
    public Order updateOrder(Long id,
                             LocalDateTime pickUpDateTime,
                             LocalDateTime deliveryDateTime,
                             Long pickUpStopId,
                             Long deliveryStopId,
                             boolean hazmat,
                             Long loadId) {

        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty())
            throw new DataNotFoundException("Order %d not found", id);

        Order order = optionalOrder.get();
        if (null != pickUpStopId && pickUpStopId != 0) {
            Location pickUpLocation = entityManager.getReference(Location.class, pickUpStopId);
            order.setPickUpStop(pickUpLocation);
        }

        if (null != deliveryStopId && deliveryStopId != 0) {
            Location deliveryLocation = entityManager.getReference(Location.class, deliveryStopId);
            order.setDeliveryStop(deliveryLocation);
        }

        order.setHazmat(hazmat);
        if(null != deliveryDateTime)
        order.setDeliveryDateTime(OffsetDateTime.of(deliveryDateTime, ZoneOffset.UTC));

        if(null != pickUpDateTime)
        order.setPickUpDateTime(OffsetDateTime.of(pickUpDateTime, ZoneOffset.UTC));

        Optional<Load> optionalLoad = loadRepository.findById(loadId);

        if (optionalLoad.isPresent())
            order.setLoad(optionalLoad.get());

        return orderRepository.save(order);

    }

    /**
     *
     * @param equipmentType
     * @param hazmat
     * @param ltl
     * @param miles
     * @param stops
     * @param weight
     * @param originId
     * @param destinationId
     * @return Load
     */
    public Load newLoad(String equipmentType,
                        boolean hazmat,
                        boolean ltl,
                        float miles,
                        int stops,
                        float weight,
                        Long originId,
                        Long destinationId
                        ) {
        Location origin = entityManager.getReference(Location.class, originId);
        Location destination = entityManager.getReference(Location.class, destinationId);

        return loadRepository.save(new Load(equipmentType,hazmat,ltl,miles,stops,weight,destination,origin));
    }
}