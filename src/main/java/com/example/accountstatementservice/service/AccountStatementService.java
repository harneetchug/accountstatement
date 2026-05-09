package com.example.accountstatementservice.service;

import com.example.accountstatementservice.reposirtory.AccountStatementRepository;
import com.example.accountstatementservice.reposirtory.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatementService {

    @Autowired
    private AccountStatementRepository accountStatementRepository;

    public List<Transaction> getRecentTransactions(String accountId) {

        List<Transaction> transactions =
                accountStatementRepository.findTop10ByAccountIdOrderByCreatedAtDesc(accountId);

        if (transactions.isEmpty()) {
            throw new RuntimeException("No transactions found");
        }

        return transactions;
    }
}
