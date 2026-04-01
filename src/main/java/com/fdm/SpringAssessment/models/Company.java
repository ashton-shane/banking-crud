package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import lombok.Builder;

@Entity
public class Company extends Customer{
    @Builder
    public Company (
            String name,
            String streetNumber,
            String city,
            String province,
            String postalCode) {
        super(name, streetNumber, city, province, postalCode);
    }
}
