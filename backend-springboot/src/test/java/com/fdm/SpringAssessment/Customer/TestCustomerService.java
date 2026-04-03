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
import static org.junit.jupiter.api.Assertions.assertNull;
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
                .building("Raffles City Tower")
                .blockNumber("250")
                .roadName("North Bridge Road")
                .fullAddress("250 North Bridge Road, Singapore 179101")
                .postalCode("179101")
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

    @Test
    public void verifyFindByIdAndSave_whenCallingUpdateName() {
        long customerId = 42L;
        when(customerRepository.findById(customerId)).thenReturn(person);

        customerService.updateName(customerId, "River");

        assertEquals("River", person.getName());
        verify(customerRepository).findById(customerId);
        verify(customerRepository).save(person);
    }

    @Test
    public void updatesAddressFieldsAndSaves_whenCallingUpdateAddress() {
        long customerId = person.getId();
        when(customerRepository.findById(customerId)).thenReturn(person);

        Address newAddress = Address.builder()
                .blockNumber("1")
                .roadName("Change Alley")
                .fullAddress("1 Change Alley, Singapore 048616")
                .postalCode("048616")
                .building("Ocean Financial Centre")
                .build();

        customerService.updateAddress(customerId, newAddress);

        assertEquals("1", person.getAddress().getBlockNumber());
        assertEquals("Change Alley", person.getAddress().getRoadName());
        assertEquals("1 Change Alley, Singapore 048616", person.getAddress().getFullAddress());
        assertEquals("048616", person.getAddress().getPostalCode());
        assertEquals("Ocean Financial Centre", person.getAddress().getBuilding());

        verify(customerRepository).findById(customerId);
        verify(customerRepository).save(person);
    }

    @Test
    public void clearsBuildingOnAddress_whenUpdateAddressWithNullBuilding() {
        long customerId = person.getId();
        when(customerRepository.findById(customerId)).thenReturn(person);

        Address newAddress = Address.builder()
                .blockNumber("10")
                .roadName("Anson Road")
                .fullAddress("10 Anson Road, Singapore 079903")
                .postalCode("079903")
                .build();

        customerService.updateAddress(customerId, newAddress);

        assertNull(person.getAddress().getBuilding());

        verify(customerRepository).findById(customerId);
        verify(customerRepository).save(person);
    }
}
