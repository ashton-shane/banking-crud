package com.fdm.SpringAssessment.models;

import com.fdm.SpringAssessment.enums.AccountType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CheckingAccount extends Account {
    private int nextCheckNumber;

    public CheckingAccount(double balance, AccountType accountType, Customer customer) {
        super (balance, accountType, customer);
    }
}
