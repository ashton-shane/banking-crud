package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Company;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomer {
    @Test
    public void returnsCorrectAttributes_whenCreateAPersonObjectWithAttributes(){
        Address address = Address.builder()
                .building("Lucky Heights Condo")
                .blockNumber("64")
                .roadName("Lucky View Road")
                .fullAddress("64 Lucky View Road, Singapore 151515")
                .postalCode("151515")
                .build();
        Person person = new Person("Ash", address);
        assertEquals("Ash", person.getName());
        assertEquals("151515", person.getAddress().getPostalCode());
    }

    @Test
    public void returnsCorrectAttributes_whenCreateACompanyObjectWithAttributes(){
        Address address = Address.builder()
                .building("HarbourFront Tower One")
                .blockNumber("55")
                .roadName("HarbourFront Walk")
                .fullAddress("55 HarbourFront Walk, Singapore 123000")
                .postalCode("123000")
                .build();
        Company company = new Company("FDM", address);
        assertEquals("FDM", company.getName());
        assertEquals("123000", company.getAddress().getPostalCode());
    }

}
