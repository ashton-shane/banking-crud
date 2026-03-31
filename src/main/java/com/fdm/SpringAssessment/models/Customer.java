package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
@NoArgsConstructor              // enable JPA reflection
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @NonNull private String name;
    private String streetNumber;
    @NonNull private String city;
    private String province;
    @NonNull private String postalCode;

    @Builder
    public Customer(String name, String streetNumber, String city, String province, String postalCode) {
        this.name = name;
        this.streetNumber = streetNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }
}
