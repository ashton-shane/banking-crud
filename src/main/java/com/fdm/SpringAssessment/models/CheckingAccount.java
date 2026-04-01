package com.fdm.SpringAssessment.models;

import com.fdm.SpringAssessment.enums.AccountType;
import lombok.Getter;

@Getter
public class CheckingAccount extends Account {
    private int nextCheckNumber;

    public CheckingAccount(double balance, AccountType accountType, Customer customer) {
        super (balance, accountType, customer);
    }
}
