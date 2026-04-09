package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.DTO.CustomerDTO;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
public class TestCustomerMVC {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        customerRepository.deleteAll();

        Address address = Address.builder()
                .blockNumber("42")
                .roadName("Serangoon Ave")
                .fullAddress("42 Serangoon Ave, SG")
                .postalCode("123456")
                .building("Test Building")
                .build();

        Person person = new Person("Ash", address);
        customerRepository.save(person);
    }

    @Test
    public void returnsListOfCustomers_whenCallingCustomersEndpoint() {
        ResponseEntity<CustomerDTO[]> response = restTemplate.getForEntity("/customers", CustomerDTO[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CustomerDTO[] customers = response.getBody();
        assertNotNull(customers);
        assertTrue(customers.length > 0);
        assertEquals("Ash", customers[0].getName());
        assertEquals("42 Serangoon Ave, SG", customers[0].getFullAddress());
    }
}
