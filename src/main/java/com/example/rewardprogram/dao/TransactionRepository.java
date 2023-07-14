package com.example.rewardprogram.dao;

import com.example.rewardprogram.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTransactionByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp start, Timestamp end);

}
