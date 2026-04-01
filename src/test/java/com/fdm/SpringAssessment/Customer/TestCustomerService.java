package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Address;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    Person person;
    Address address;

    @BeforeEach
    public void test_config(){
        address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        person = new Person("Ash", address);
    }

    @Test
    public void verifyCallOnce_whenCallingFindById() {
        customerService.findById(person.getId());
        verify(customerRepository).findById(person.getId());
    }

    @Test
    public void returnsName_whenCallingFindById() {
        long custId = person.getId();
        when(customerRepository.findById(custId)).thenReturn(person);
        assertEquals("Ash", customerService.findById(custId).getName());
    }

    @Test
    public void verifyCallOnce_whenCallingDeleteById() {
        customerService.deleteById(person.getId());
        verify(customerRepository).deleteById(person.getId());
    }

    @Test
    public void returnsArrayOfSizeThree_whenCallingGetCustomers() {
        Address address1 = mock(Address.class);
        Address address2 = mock(Address.class);

        ArrayList<Customer> mockCustomers = new ArrayList<>(Arrays.asList(
                person,
                new Person("Ben", address1),
                new Person("Vivian", address2)
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
