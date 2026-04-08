package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomerDTO {

    @Test
    public void person_getters_returnValues() {
        Address address = Address.builder()
                .blockNumber("1")
                .roadName("Test Road")
                .fullAddress("1 Test Road, SG")
                .postalCode("000001")
                .building("Test Building")
                .build();

        Person p = new Person("Alice", address);

        assertEquals("Alice", p.getName());
        assertEquals(address, p.getAddress());
        assertEquals("1 Test Road, SG", p.getAddress().getFullAddress());
    }
}
