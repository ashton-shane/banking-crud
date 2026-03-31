package com.fdm.SpringAssessment;

import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestCustomerRepo {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void returnsTrue_whenCreatingAndSavingNewCustomers() {
        Customer customer1 = new Customer("Ash", "64", "SG", "SG", "640555");
        Customer customer2 = new Customer("Ben", "55", "SG", "SG", "222529");
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        long id = customer2.getCustomerId();
        assertTrue(customer1.getCustomerId() > 0);
        assertTrue(customer2.getCustomerId() > 0);
    }

    @Test
    public void returnsTrue_whenRemovingCustomerByCustomerId() {
        Customer customer1 = new Customer("Ben", "55", "SG", "SG", "222529");
        customerRepository.save(customer1);
        long custId = customer1.getCustomerId();
        customerRepository.deleteById(custId);
        assertNull(customerRepository.findById(custId));
    }
}
