package com.fdm.SpringAssessment.service;
import com.fdm.SpringAssessment.DTO.CustomerDTO;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = toPerson(customerDTO);
        customerRepository.save(customer);
    }

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer not found")
        );
    }

    public void deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public void updateCustomer(Long customerId, CustomerDTO customerDTO) {
    Customer custToUpdate = findById(customerId);
    if (custToUpdate == null) return;

    Address address = Address.builder()
        .blockNumber(customerDTO.getBlockNumber())
        .building(customerDTO.getBuilding())
        .roadName(customerDTO.getRoadName())
        .postalCode(customerDTO.getPostalCode())
        .fullAddress(customerDTO.getFullAddress())
        .build();

    custToUpdate.setAddress(address);
    custToUpdate.setName(customerDTO.getName());

    customerRepository.save(custToUpdate);
    }

    // HELPERS
    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .blockNumber(customer.getAddress().getBlockNumber())
                .roadName(customer.getAddress().getRoadName())
                .building(customer.getAddress().getBuilding())
                .postalCode(customer.getAddress().getPostalCode())
                .fullAddress(customer.getAddress().getFullAddress())
                .accountIds(
                        customer.getAccounts()
                                .stream()
                                .map(Account::getId)
                                .toList()
                )
                .build();
    }
    public Customer toPerson(CustomerDTO dto) {
        Address address = Address.builder()
                .blockNumber(dto.getBlockNumber())
                .roadName(dto.getRoadName())
                .building(dto.getBuilding())
                .postalCode(dto.getPostalCode())
                .fullAddress(dto.getFullAddress())
                .build();

        return new Person(dto.getName(), address);
    }
}

