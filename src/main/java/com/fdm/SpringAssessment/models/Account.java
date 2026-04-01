package com.fdm.SpringAssessment.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull private Double balance;
    @NonNull
    @OneToOne
    private Customer customer;
}
