package com.fdm.SpringAssessment.DTO;

import com.fdm.SpringAssessment.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    private Long id;
    private Double balance;
    private AccountType accountType;

    // flatten customer info (no nested object)
    private long customerId;
    private String customerName;
}
