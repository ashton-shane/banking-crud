package com.fdm.SpringAssessment.repository;

import com.fdm.SpringAssessment.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
    void deleteById(long id);
    ArrayList<Account> findAll();
}
