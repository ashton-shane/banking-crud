package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TestCustomerRepo {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void returnsCustomerName_whenFindingCustomerById() {
        Person person1 = Person.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("640555")
                .build();
        customerRepository.save(person1);
        Customer foundCust = customerRepository.findById(person1.getCustomerId());
        System.out.println(foundCust.getName());
        assertEquals("Ash", foundCust.getName());
    }

    @Test
    public void returnsTrue_whenCreatingAndSavingNewCustomers() {
        Person person1 = new Person("Ash", "64", "SG", "SG", "640555");
        Person person2 = new Person("Ben", "55", "SG", "SG", "222529");
        customerRepository.save(person1);
        customerRepository.save(person2);
        assertTrue(person1.getCustomerId() > 0);
        assertTrue(person2.getCustomerId() > 0);
    }

    @Test
    public void returnsTrue_whenRemovingCustomerByCustomerId() {
        Person person1 = new Person("Ben", "55", "SG", "SG", "222529");
        customerRepository.save(person1);
        long custId = person1.getCustomerId();
        customerRepository.deleteById(custId);
        assertNull(customerRepository.findById(custId));
    }
}
