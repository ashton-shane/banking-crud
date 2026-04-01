package com.fdm.SpringAssessment.service;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findById(long customerId) {
        return customerRepository.findById(customerId);
    }

    public void deleteById(long customerId) {
        customerRepository.deleteById(customerId);
    }

    public ArrayList<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}

