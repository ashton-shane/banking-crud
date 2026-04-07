package com.fdm.SpringAssessment.repository;

import com.fdm.SpringAssessment.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(long id);
    void deleteById(long id);
    ArrayList<Account> findAll();
}
