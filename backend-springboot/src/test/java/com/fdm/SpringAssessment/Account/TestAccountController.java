package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.controllers.AccountController;
import com.fdm.SpringAssessment.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
    public void forwardsFindByIdToService() {
        long id = 7L;
        when(accountService.findById(id)).thenReturn(null);
        accountController.findById(id);
        verify(accountService).findById(id);
    }


}
