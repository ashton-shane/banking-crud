package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.DTO.AccountDTO;
import com.fdm.SpringAssessment.enums.AccountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountDTO {

    @Test
    public void accountDto_getters_returnValues() {
        AccountDTO dto = new AccountDTO(1L, 123.45, AccountType.SAVINGS, 42L, "Alice");

        assertEquals(1L, dto.getId());
        assertEquals(Double.valueOf(123.45), dto.getBalance());
        assertEquals(AccountType.SAVINGS, dto.getAccountType());
        assertEquals(42L, dto.getCustomerId());
        assertEquals("Alice", dto.getCustomerName());
    }
}
