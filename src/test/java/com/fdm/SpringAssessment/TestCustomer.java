package com.fdm.SpringAssessment;

import com.fdm.SpringAssessment.models.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomer {
    @Test
    public void returnsCorrectAttributes_whenCreateAUserObjectWithAttributes(){
        Customer customer = new Customer("Ash", "64", "SG", "SG", "640555");
        assertEquals("Ash", customer.getName());
        assertEquals("640555", customer.getPostalCode());
    }

    @Test
    public void returnsIdOfOne_whenGettingId() {
        Customer customer1 = new Customer("Ash", "64", "SG", "SG", "640555");
        Customer customer2 = new Customer("Ben", "64", "SG", "SG", "640555");
        long id = customer2.getCustomerId();
        assertEquals(1, id);
    }
}
