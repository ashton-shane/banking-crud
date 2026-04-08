package com.fdm.SpringAssessment.repository;

import com.fdm.SpringAssessment.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(long id);
    void deleteById(long id);
    ArrayList<Customer> findAll();

}
