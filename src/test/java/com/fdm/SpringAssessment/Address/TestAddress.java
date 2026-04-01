package com.fdm.SpringAssessment.Address;

import com.fdm.SpringAssessment.models.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAddress {
    @Test
    public void returnsCorrectAttributes_whenCreateAddressObjectWithAllAttributes() {
        Address address = Address.builder()
                .building("Lucky Heights Condo")
                .blockNumber("64")
                .roadName("Lucky View Road")
                .fullAddress("64 Lucky View Road, Singapore 151515")
                .postalCode("151515")
                .build();

        assertEquals("Lucky Heights Condo", address.getBuilding());
        assertEquals("64", address.getBlockNumber());
        assertEquals("Lucky View Road", address.getRoadName());
        assertEquals("64 Lucky View Road, Singapore 151515", address.getFullAddress());
        assertEquals("151515", address.getPostalCode());
    }

    @Test
    public void returnsCorrectAttributes_whenCreateAddressObjectWithoutBuilding() {
        Address address = Address.builder()
                .blockNumber("55")
                .roadName("HarbourFront Walk")
                .fullAddress("55 HarbourFront Walk, Singapore 123000")
                .postalCode("123000")
                .build();

        assertNull(address.getBuilding());
        assertEquals("55", address.getBlockNumber());
        assertEquals("HarbourFront Walk", address.getRoadName());
        assertEquals("55 HarbourFront Walk, Singapore 123000", address.getFullAddress());
        assertEquals("123000", address.getPostalCode());
    }
}
