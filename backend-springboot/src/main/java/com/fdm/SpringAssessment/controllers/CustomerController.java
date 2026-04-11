package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.DTO.CustomerDTO;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }

    // singular customer route (requested): /customer/{id}
    @GetMapping("/{customerId}")
    public CustomerDTO findById(@PathVariable long customerId) {
        return customerService.findById(customerId);
    }

    @PostMapping("/create")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable long customerId) {
        customerService.deleteById(customerId);
    }

    @GetMapping("/customers/{customerId}/address")
    public void updateAddress(@PathVariable long customerId, Address address) {
        customerService.updateAddress(customerId, address);
    }

    @GetMapping("/customers/{customerId}/name")
    public void updateName(@PathVariable long customerId, String name) {
        customerService.updateName(customerId, name);
    }


}
