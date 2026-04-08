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
                .building("Marina Bay Residences")
                .blockNumber("18")
                .roadName("Marina Boulevard")
                .fullAddress("18 Marina Boulevard, Singapore 018980")
                .postalCode("018980")
                .build();
        Person person = new Person("Ash", address);

    customerRepository.save(person);
    Customer foundCust = customerRepository.findById(person.getId()).orElse(null);

        assertEquals("Ash", foundCust.getName());
    }

    @Test
    public void returnsTrue_whenCreatingAndSavingNewCustomers() {
        Address address1 = Address.builder()
                .building("Tiong Bahru Plaza")
                .blockNumber("302")
                .roadName("Tiong Bahru Road")
                .fullAddress("302 Tiong Bahru Road, Singapore 168732")
                .postalCode("168732")
                .build();
        Person person1 = new Person("Ash", address1);

        Address address2 = Address.builder()
                .building("Holland Village Hub")
                .blockNumber("7")
                .roadName("Holland Avenue")
                .fullAddress("7 Holland Avenue, Singapore 275748")
                .postalCode("275748")
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
                .building("Marina Bay Residences")
                .blockNumber("18")
                .roadName("Marina Boulevard")
                .fullAddress("18 Marina Boulevard, Singapore 018980")
                .postalCode("018980")
                .build();
        Person person = new Person("Ash", address);
    customerRepository.save(person);
    long custId = person.getId();
    customerRepository.deleteById(custId);
    assertNull(customerRepository.findById(custId).orElse(null));
    }
}
