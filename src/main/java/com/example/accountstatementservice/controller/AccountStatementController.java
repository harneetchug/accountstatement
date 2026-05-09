package com.example.accountstatementservice.controller;


import com.example.accountstatementservice.reposirtory.Transaction;
import com.example.accountstatementservice.service.AccountStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/accounts")
    public class AccountStatementController {

    @Autowired
    private AccountStatementService accountStatementService;

        @GetMapping("/{accountId}/transactions")
        public List<Transaction> getTransactions(@PathVariable String accountId) {
            return accountStatementService.getRecentTransactions(accountId);
        }
    }

