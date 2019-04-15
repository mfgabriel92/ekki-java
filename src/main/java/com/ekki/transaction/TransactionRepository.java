package com.ekki.transaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("SELECT COUNT(id) > 0 FROM Beneficiary WHERE id = ?1")
    public Boolean hasBeneficiaryWithId(int beneficiaryId);
}