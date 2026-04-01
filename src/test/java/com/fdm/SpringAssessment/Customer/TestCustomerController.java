package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.controllers.CustomerController;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestCustomerController {
    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    public void verifyCallOnce_whenCallingUpdateName() {
        customerController.updateName(42L, "River");
        verify(customerService).updateName(42L, "River");
    }

    @Test
    public void verifyCallOnce_whenCallingUpdateAddress() {
        Address address = Address.builder()
                .blockNumber("1")
                .roadName("Change Alley")
                .fullAddress("1 Change Alley, Singapore 048616")
                .postalCode("048616")
                .building("Ocean Financial Centre")
                .build();

        customerController.updateAddress(99L, address);
        verify(customerService).updateAddress(99L, address);
    }
}
