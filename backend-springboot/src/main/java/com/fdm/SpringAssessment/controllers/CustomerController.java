package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public ArrayList<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // singular customer route (requested): /customer/{id}
    @GetMapping("/customer/{customerId}")
    public Customer findById(@PathVariable long customerId) {
        return customerService.findById(customerId);
    }

    // kept as GETs to avoid changing semantics in this patch — only paths adjusted to avoid mapping collisions
    @GetMapping("/customers/create")
    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping("/customers/delete/{customerId}")
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
