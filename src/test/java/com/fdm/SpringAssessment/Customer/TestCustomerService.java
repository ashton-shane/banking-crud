package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import com.fdm.SpringAssessment.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    Person person;

    @BeforeEach
    public void test_config(){
        person = Person.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("666555")
                .build();
    }

    @Test
    public void verifyCallOnce_whenCallingFindById() {
        customerService.findById(person.getCustomerId());
        verify(customerRepository).findById(person.getCustomerId());
    }

    @Test
    public void returnsName_whenCallingFindById() {
        long custId = person.getCustomerId();
        when(customerRepository.findById(custId)).thenReturn(person);
        assertEquals("Ash", customerService.findById(custId).getName());
    }

    @Test
    public void verifyCallOnce_whenCallingDeleteById() {
        customerService.deleteById(person.getCustomerId());
        verify(customerRepository).deleteById(person.getCustomerId());
    }

    @Test
    public void returnsArrayOfSizeThree_whenCallingGetCustomers() {
        ArrayList<Customer> mockCustomers = new ArrayList<>(Arrays.asList(
                person,
                new Person("Ben", "64", "SG", "SG", "640555"),
                new Person("Vivian", "64", "SG", "SG", "640555")
        ));

        when(customerRepository.findAll()).thenReturn(mockCustomers);
        assertEquals(3, customerService.getCustomers().size());
    }

    @Test
    public void verifyCallOnce_whenCallingCreateCustomer() {
        customerService.createCustomer(person);
        verify(customerRepository).save(person);
    }
}
