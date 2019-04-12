package com.ekki.transfer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Integer> {
    @Query("SELECT COUNT(id) > 0 FROM Beneficiary WHERE id = ?1")
    public Boolean hasBeneficiaryWithId(int id);
}