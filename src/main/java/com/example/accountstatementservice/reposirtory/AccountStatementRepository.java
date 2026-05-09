package com.example.accountstatementservice.reposirtory;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountStatementRepository extends JpaRepository<Transaction, Long>  {

        List<Transaction> findTop10ByAccountIdOrderByCreatedAtDesc(String accountId);
}

