package com.fdm.SpringAssessment.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String name;

    // Flattened address
    private String blockNumber;
    private String roadName;
    private String building;
    private String postalCode;
    private String fullAddress;

    private List<Long> accountIds;
}
