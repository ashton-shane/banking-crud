package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String streetNumber;
    private String city;
    private String postalCode;

    @Builder
    public Address(String streetNumber, String city, String postalCode) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.postalCode = postalCode;
    }
}
