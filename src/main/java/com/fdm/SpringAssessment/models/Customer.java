package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String name;
    private String streetNumber;
    private String city;
    private String province;
    private String postalCode;

    // empty constructor to enable JPA to use reflection
    public Customer() {};

    // main constructor
    public Customer(String name, String streetNumber, String city, String province, String postalCode) {
        this.name = name;
        this.streetNumber = streetNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }
}
