package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class UserController {
    private final CustomerService customerService;

    @GetMapping
    public ArrayList<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
