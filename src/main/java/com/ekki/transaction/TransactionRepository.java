package com.ekki.transaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t WHERE transaction_user_id = ?1 ORDER BY transaction_created_at DESC")
    public Iterable<Transaction> findAll(int transactionUserId);
}