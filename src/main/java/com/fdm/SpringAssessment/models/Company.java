package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Company extends Customer {
    public Company (String name, Address address) {
        super(name, address);
    }
}
