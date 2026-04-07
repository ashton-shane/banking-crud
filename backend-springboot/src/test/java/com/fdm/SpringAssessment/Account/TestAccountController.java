package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.controllers.AccountController;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.de.siegmar.fastcsv.util.Nullable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TestAccountController {
    @Mock
    AccountService accountService;

    @InjectMocks
    AccountController accountController;

    @Test
    public void forwardsGetAccountsToService() {
        accountController.getAccounts();
        verify(accountService).getAccounts();
    }

    @Test
    public void throwsWhenAccountNotFound() {
        long id = 7L;

        when(accountService.findById(id)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> accountController.findById(id));
        verify(accountService).findById(id);
    }
}
