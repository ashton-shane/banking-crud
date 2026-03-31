package com.fdm.SpringAssessment.service;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer findById(long id) {
        return customerRepository.findById(id);
    }
}
