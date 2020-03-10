package com.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue
    private final Long id = null;
    private String note;
    private ZonedDateTime createdOn;
    @ManyToOne(fetch = FetchType.EAGER)
    private Person author;
}