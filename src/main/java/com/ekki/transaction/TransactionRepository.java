package com.ekki.transaction;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t WHERE transaction_user_id = ?1 ORDER BY transaction_created_at DESC")
    public Iterable<Transaction> findAll(int transactionUserId);

    @Query(value = "SELECT t.* FROM transactions t WHERE transaction_created_at >= NOW() - INTERVAL 2 MINUTE AND t.transaction_user_id = ?1 AND t.transaction_amount = ?2 AND t.transaction_beneficiary_id = ?3", nativeQuery = true)
    public Optional<Transaction> findTransactionLessThan2MinutesAgo(int transactionUserId, double transactionAmount, int transactionBeneficiaryId);
}