package com.logistics.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String city;
    @NotNull
    private String state;

    @NotNull
    @Column(unique = true)
    private String zipCode;

    public Location(String city, String state, String zipCode) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}