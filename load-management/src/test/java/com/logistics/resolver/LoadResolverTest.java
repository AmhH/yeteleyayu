package com.logistics.resolver;

import com.logistics.exception.DataNotFoundException;
import com.logistics.model.Load;
import com.logistics.model.Location;
import com.logistics.model.Order;
import com.logistics.repository.LocationRepository;
import com.logistics.repository.OrderRepository;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoadResolverTest {

    @InjectMocks
    private LoadResolver loadResolver;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private OrderRepository orderRepository;

    private Location location;
    private Load load;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp(){
        location = new Location("Dallas", "TX", "75098");
        location.setId(9l);

        load = new Load();
        load.setId(12l);
        load.setOrigin(location);
        load.setDestination(location);
    }

    @Test
    public void getOriginReturnLocationSearchingBYId(){

        when(locationRepository.findById(anyLong()))
                .thenReturn(Optional.of(location));

        Location origin = loadResolver.getOrigin(load);

        assertNotNull(origin);
        assertThat(origin.getId(), is(9l));
        assertThat(origin, is(location));

        verify(locationRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getOriginThrowsErrorIfLocationNotFound(){
        exceptionRule.expect(DataNotFoundException.class);
        exceptionRule.expectMessage("Origin location 9 not found");

        when(locationRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        loadResolver.getOrigin(load);
    }

    @Test
    public void getDestination_ReturnsLocation(){
        when(locationRepository.findById(anyLong()))
                .thenReturn(Optional.of(location));

        Location origin = loadResolver.getDestination(load);

        assertNotNull(origin);
        assertThat(origin.getId(), is(9l));
        assertThat(origin, is(location));

        verify(locationRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getDestinationThrowsErrorIfLocationNotFound(){
        exceptionRule.expect(DataNotFoundException.class);
        exceptionRule.expectMessage("Origin location 9 not found");

        when(locationRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        loadResolver.getOrigin(load);
    }


    @Test(expected = NullPointerException.class)
    public void getDestination_throwsNullPointerExceptionWhenNoLocationIsSet(){
        when(locationRepository.findById(anyLong()))
                .thenReturn(Optional.of(location));

        Location origin = loadResolver.getDestination(new Load());

        assertNotNull(origin);
        assertThat(origin.getId(), is(9l));
        assertThat(origin, is(location));

        verify(locationRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getOrders_returnsOrderAssociatedWithLoad(){
        when(orderRepository.findByLoadId(anyLong())).thenReturn(List.of(new Order()));

        List<Order> orders = loadResolver.getOrders(load);

        assertThat(orders, hasSize(1));
    }

    @Test
    public void getOrders_returnsEmptyList_IfIdNotFount(){
        when(orderRepository.findByLoadId(anyLong())).thenReturn(List.of(new Order()));

        List<Order> orders = loadResolver.getOrders(new Load());

        assertThat(orders, hasSize(0));
    }
}