package com.transactions.Transactions.Repository;

import com.transactions.Transactions.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionsRepo extends JpaRepository<Transactions, Integer>{
    List<Transactions> findTop10ByUserIdOrderByTimestamp(Integer user_id);
}
