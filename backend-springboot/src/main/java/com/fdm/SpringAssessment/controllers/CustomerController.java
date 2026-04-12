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

    @GetMapping("/{customerId}")
    public CustomerDTO findById(@PathVariable Long customerId) {
        Customer customer = customerService.findById(customerId);
        return customerService.toDTO(customer);
    }

    @PostMapping("/create")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteById(customerId);
    }

    @PutMapping("/update/{customerId}")
    public void updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerId, customerDTO);
    }


}
