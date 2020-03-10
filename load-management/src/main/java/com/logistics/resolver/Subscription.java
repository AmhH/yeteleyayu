package com.logistics.resolver;

import com.logistics.model.Location;
import com.logistics.publisher.LocationPublisher;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
public class Subscription {
    public LocationPublisher publisher;

    public Subscription(LocationPublisher publisher) {
        this.publisher = publisher;
    }

    public Publisher<Location> locationsPublished() {
        return publisher.getPublisher();
    }
}
