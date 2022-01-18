package com.example.pharmacia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "booking")
public class Booking {

    @javax.persistence.Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )

    private Long id;
    private String name;
    private String number;
    private String email;
    private String message;
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id"
    )
    private User user;
}
