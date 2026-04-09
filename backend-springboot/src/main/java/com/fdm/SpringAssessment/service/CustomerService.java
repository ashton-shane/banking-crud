package com.fdm.SpringAssessment.service;
import com.fdm.SpringAssessment.DTO.CustomerDTO;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Customer;
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

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public CustomerDTO findById(long customerId) {
        Customer cust = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer not found")
        );
        return toDTO(cust);
    }

    public void deleteById(long customerId) {
        customerRepository.deleteById(customerId);
    }

    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public void updateAddress(long customerId, Address newAddress) {
    Optional<Customer> maybeCust = customerRepository.findById(customerId);
    Customer custToUpdate = maybeCust.orElse(null);
    if (custToUpdate == null) return;
    Address addressToUpdate = custToUpdate.getAddress();

        // full update for simplicity
        addressToUpdate.setBlockNumber(newAddress.getBlockNumber());
        addressToUpdate.setBuilding(newAddress.getBuilding());
        addressToUpdate.setRoadName(newAddress.getRoadName());
        addressToUpdate.setPostalCode(newAddress.getPostalCode());
        addressToUpdate.setFullAddress(newAddress.getFullAddress());

        customerRepository.save(custToUpdate);
    }

    public void updateName(long customerId, String name) {
    Optional<Customer> maybeCust2 = customerRepository.findById(customerId);
    Customer custToUpdate2 = maybeCust2.orElse(null);
    if (custToUpdate2 == null) return;
    custToUpdate2.setName(name);

    customerRepository.save(custToUpdate2);
    }

    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .blockNumber(customer.getAddress().getBlockNumber())
                .roadName(customer.getAddress().getRoadName())
                .building(customer.getAddress().getBuilding())
                .postalCode(customer.getAddress().getPostalCode())
                .accountIds(
                        customer.getAccounts()
                                .stream()
                                .map(Account::getId)
                                .toList()
                )
                .build();
    }
}

