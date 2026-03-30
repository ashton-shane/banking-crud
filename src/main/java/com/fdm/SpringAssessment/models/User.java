package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String name;
    private String streetNumber;
    private String city;
    private String province;
    private String postalCode;

    public User(String name, String streetNumber, String city, String province, String postalCode) {
        this.name = name;
        this.streetNumber = streetNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    // getters
    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

}
