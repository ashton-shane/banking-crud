package com.fdm.SpringAssessment.OneMap;

import com.fdm.SpringAssessment.controllers.OneMapController;
import com.fdm.SpringAssessment.service.OneMapService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class TestOneMapController {
    @Mock
    OneMapService oneMapService;

    @Test
    public void verifyCallOnce_whenCallingOneMapApi() {
        String postalCode = "666555";
        OneMapController oneMapController = new OneMapController(oneMapService);
        oneMapController.callOneMapAPI(postalCode);
        verify(oneMapService).getAddressByPostalCode(postalCode);}
}
