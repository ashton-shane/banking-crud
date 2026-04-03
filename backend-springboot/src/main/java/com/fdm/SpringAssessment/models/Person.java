package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Person extends Customer {
    public Person(String name, Address address) {
        super(name, address);
    }
}
