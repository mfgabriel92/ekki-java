package com.ekki.transaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("SELECT COUNT(id) > 0 FROM Beneficiary WHERE id = ?1")
    public Boolean hasBeneficiaryWithId(int beneficiaryId);

    @Query("SELECT t FROM Transaction t WHERE userId = ?1 ORDER BY createdAt DESC")
    public Iterable<Transaction> findAll(int userId);
}