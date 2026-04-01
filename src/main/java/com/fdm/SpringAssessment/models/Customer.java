package com.fdm.SpringAssessment.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
@NoArgsConstructor              // enable JPA reflection
public abstract class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String name;
    private String streetNumber;
    private String city;
    private String province;
    private String postalCode;

    @OneToMany(mappedBy = "customer")
    List<Account> accounts = new ArrayList<>();

    public Customer(String name, String streetNumber, String city, String province, String postalCode) {
        this.name = name;
        this.streetNumber = streetNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }
}
