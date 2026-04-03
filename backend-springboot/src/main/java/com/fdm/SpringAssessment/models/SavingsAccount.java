package com.fdm.SpringAssessment.models;

import com.fdm.SpringAssessment.enums.AccountType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, AccountType accountType, Customer customer) {
        super (balance, accountType, customer);
    }
}
