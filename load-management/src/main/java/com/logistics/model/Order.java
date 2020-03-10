package com.logistics.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "`ORDER`")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DELIVERY_DATE_TIME")
    private OffsetDateTime deliveryDateTime;

    @NotNull
    @Column(name = "HAZMAT")
    private boolean hazmat;

    @NotNull
    @Column(name = "PICK_UP_DATE_TIME")
    private OffsetDateTime pickUpDateTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_STOP_ID", nullable = false)
    private Location deliveryStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOAD_ID", nullable = true)
    private Load load;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PICK_UP_STOP_ID", nullable = false)
    private Location pickUpStop;

    public Order(OffsetDateTime pickUpDateTime,
                 boolean hazmat,
                 OffsetDateTime deliveryDateTime) {

        this.deliveryDateTime = deliveryDateTime;
        this.hazmat = hazmat;
        this.pickUpDateTime = pickUpDateTime;
    }
}
