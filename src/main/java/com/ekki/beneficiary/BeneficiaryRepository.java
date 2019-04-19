package com.ekki.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Integer> {
    @Query("SELECT b FROM Beneficiary b WHERE beneficiary_user_id = ?1 ORDER BY beneficiary_created_at DESC")
    public Iterable<Beneficiary> findAll(int beneficiaryUserId);
}