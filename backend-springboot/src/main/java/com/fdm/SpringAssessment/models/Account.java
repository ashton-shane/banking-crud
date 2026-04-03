package com.fdm.SpringAssessment.models;

import com.fdm.SpringAssessment.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private Double balance;

    @NonNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
