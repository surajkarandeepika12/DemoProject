package com.transactions.Transactions.service;

import com.transactions.Transactions.Repository.TransactionsRepo;
import com.transactions.Transactions.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Transactionsservice {
    @Autowired
    private final TransactionsRepo transactionsRepo;

    public Transactionsservice(TransactionsRepo transactionsRepo) {
        this.transactionsRepo = transactionsRepo;
    }
    public List<Transactions> getLastTransactions(Integer user_id, int Limit){
         return transactionsRepo.findTop10ByUserIdOrderByTimestamp(user_id);
    }


}
