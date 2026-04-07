package com.fdm.SpringAssessment.DTO;

import com.fdm.SpringAssessment.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountDTO {

    private long id;
    private Double balance;
    private AccountType accountType;

    // flatten customer info (no nested object)
    private long customerId;
    private String customerName;
}
