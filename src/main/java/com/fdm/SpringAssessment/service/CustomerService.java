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

    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public ArrayList<Customer> findAll() {
        return customerRepository.findAll();
    }


}

