package com.ekki.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Integer> {
    @Query("SELECT b FROM Beneficiary b WHERE user_id = ?1 ORDER BY created_at DESC")
    public Iterable<Beneficiary> findAll(int userId);
}