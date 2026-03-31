package com.fdm.SpringAssessment;

import com.fdm.SpringAssessment.models.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomer {
    @Test
    public void returnsCorrectAttributes_whenCreateAUserObjectWithAttributes(){
        Customer customer = Customer.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("640555")
                .build();
        assertEquals("Ash", customer.getName());
        assertEquals("640555", customer.getPostalCode());
    }

}
