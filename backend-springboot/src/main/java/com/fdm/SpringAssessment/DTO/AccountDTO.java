package com.fdm.SpringAssessment.DTO;

import com.fdm.SpringAssessment.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class AccountDTO {

    private long id;
    private Double balance;
    private AccountType accountType;

    // flatten customer info (no nested object)
    private long customerId;
    private String customerName;
}
