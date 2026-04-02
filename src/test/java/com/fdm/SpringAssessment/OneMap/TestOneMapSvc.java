package com.fdm.SpringAssessment.OneMap;

import com.fdm.SpringAssessment.service.OneMapService;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOneMapSvc {
    @Test
    public void returnsAddressString_whenCallingApi() {
        Dotenv dotenv = Dotenv.load();
        OneMapService oneMapService = new OneMapService(dotenv);
        String result = oneMapService.getAddressByPostalCode("680351");
        assertEquals("Hi", result);
    }
}
