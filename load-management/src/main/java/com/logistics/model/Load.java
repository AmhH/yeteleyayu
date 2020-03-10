package com.logistics.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipment_type")
    private String equipmentType;
    private boolean hazmat;
    private boolean ltl;
    private float miles;
    private int stops;
    private float weight;

    @ManyToOne
    private Location destination;
    @ManyToOne
    private Location origin;

    @OneToMany(mappedBy = "load", fetch = FetchType.LAZY)
    private List<Order> order;

    public Load(String equipmentType,
                boolean hazmat,
                boolean ltl,
                float miles,
                int stops,
                float weight,
                Location destination,
                Location origin) {
        this.equipmentType = equipmentType;
        this.hazmat = hazmat;
        this.ltl = ltl;
        this.miles = miles;
        this.stops = stops;
        this.weight = weight;
        this.destination = destination;
        this.origin = origin;
    }
}
