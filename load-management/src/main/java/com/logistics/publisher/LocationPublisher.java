package com.logistics.publisher;

import com.logistics.model.Location;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationPublisher {
    private final Flowable<Location> publisher;
    public ObservableEmitter<Location> emitter;

    public LocationPublisher() {
        Observable<Location> commentUpdateObservable = Observable.create(emitter -> this.emitter = emitter);
        ConnectableObservable<Location> connectableObservable = commentUpdateObservable.share().publish();
        connectableObservable.connect();
        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void publish(final Location location) {
        emitter.onNext(location);
    }

    public Flowable<Location> getPublisher() {
        return this.publisher;
    }
}
