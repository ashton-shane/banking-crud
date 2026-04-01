package com.fdm.SpringAssessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String blockNumber;
    private String roadName;
    private String building;
    private String fullAddress;
    private String postalCode;


    @Builder
    public Address(@NonNull String building,
                   String blockNumber,
                   String roadName,
                   String fullAddress,
                   String postalCode
    )
    {
        this.building = building;
        this.blockNumber = blockNumber;
        this.roadName = roadName;
        this.fullAddress = fullAddress;
        this.postalCode = postalCode;
    }
}
