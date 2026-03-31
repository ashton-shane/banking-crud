package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Customer;
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

    Customer customer;

    @BeforeEach
    public void test_config(){
        customer = Customer.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("666555")
                .build();
    }

    @Test
    public void verifyCallOnce_whenCallingFindById() {
        customerService.findById(customer.getCustomerId());
        verify(customerRepository).findById(customer.getCustomerId());
    }

    @Test
    public void returnsName_whenCallingFindById() {
        long custId = customer.getCustomerId();
        when(customerRepository.findById(custId)).thenReturn(customer);
        assertEquals("Ash", customerService.findById(custId).getName());
    }

    @Test
    public void verifyCallOnce_whenCallingDeleteById() {
        customerService.deleteById(customer.getCustomerId());
        verify(customerRepository).deleteById(customer.getCustomerId());
    }

    @Test
    public void returnsArrayOfSizeThree_whenCallingGetCustomers() {
        ArrayList<Customer> mockCustomers = new ArrayList<>(Arrays.asList(
                customer,
                new Customer("Ben", "64", "SG", "SG", "640555"),
                new Customer("Vivian", "64", "SG", "SG", "640555")
        ));

        when(customerRepository.findAll()).thenReturn(mockCustomers);
        assertEquals(3, customerService.getCustomers().size());
    }

    @Test
    public void verifyCallOnce_whenCallingCreateCustomer() {
        customerService.createCustomer(customer);
        verify(customerRepository).save(customer);
    }
}
