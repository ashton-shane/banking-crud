package com.fdm.SpringAssessment.models;

import com.fdm.SpringAssessment.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, AccountType accountType, Customer customer) {
        super (balance, accountType, customer);
    }
}
