package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TestCustomerRepo {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void returnsCustomerName_whenFindingCustomerById() {
        Address address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Ash", address);

        customerRepository.save(person);
        Customer foundCust = customerRepository.findById(person.getId());

        assertEquals("Ash", foundCust.getName());
    }

    @Test
    public void returnsTrue_whenCreatingAndSavingNewCustomers() {
        Address address1 = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person1 = new Person("Ash", address1);

        Address address2 = Address.builder()
                .city("Singapore")
                .postalCode("222222")
                .streetNumber("55")
                .build();
        Person person2 = new Person("Bob", address2);

        customerRepository.save(person1);
        customerRepository.save(person2);

        assertTrue(person1.getId() > 0);
        assertTrue(person2.getId() > 0);
    }

    @Test
    public void returnsTrue_whenRemovingCustomerByCustomerId() {
        Address address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Ash", address);
        customerRepository.save(person);
        long custId = person.getId();
        customerRepository.deleteById(custId);
        assertNull(customerRepository.findById(custId));
    }
}
