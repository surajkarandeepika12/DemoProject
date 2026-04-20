package com.transactions.Transactions.controller;

import com.transactions.Transactions.Transactions;
import com.transactions.Transactions.service.Transactionsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsController {
    @Autowired
    private final Transactionsservice transactionsservice;

    public TransactionsController(Transactionsservice transactionsservice) {
        this.transactionsservice = transactionsservice;
    }

    @GetMapping("/{user_id}/transactions")
    List<Transactions> getLastTransactions(@PathVariable Integer user_id){
        return transactionsservice.getLastTransactions(user_id, 10);
    }
}
