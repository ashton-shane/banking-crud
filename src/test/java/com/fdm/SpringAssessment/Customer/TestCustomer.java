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
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Ash", address);
        assertEquals("Ash", person.getName());
        assertEquals("151515", person.getAddress().getPostalCode());
    }

    @Test
    public void returnsCorrectAttributes_whenCreateACompanyObjectWithAttributes(){
        Address address = Address.builder()
                .city("Singapore")
                .postalCode("123000")
                .streetNumber("55")
                .build();
        Company company = new Company("FDM", address);
        assertEquals("FDM", company.getName());
        assertEquals("123000", company.getAddress().getPostalCode());
    }

}
