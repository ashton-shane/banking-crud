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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts = new ArrayList<>();

    // constructor
    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
