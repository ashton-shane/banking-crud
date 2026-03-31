package com.fdm.SpringAssessment.repository;

import com.fdm.SpringAssessment.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);
    Customer deleteById(long id);
    ArrayList<Customer> findAll();
}
