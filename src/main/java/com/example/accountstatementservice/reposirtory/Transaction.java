package com.example.accountstatementservice.reposirtory;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private String accountId;
    private Double amount;
    private String type; // DEBIT / CREDIT
    private String description;
    private Instant createdAt;
}

