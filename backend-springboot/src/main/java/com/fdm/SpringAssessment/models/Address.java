package com.fdm.SpringAssessment.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
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
    public Address(@NonNull String blockNumber,
                   @NonNull String roadName,
                   @NonNull String fullAddress,
                   @NonNull String postalCode,
                   String building) {
        this.blockNumber = blockNumber;
        this.roadName = roadName;
        this.fullAddress = fullAddress;
        this.postalCode = postalCode;
        this.building = building;
    }
}
