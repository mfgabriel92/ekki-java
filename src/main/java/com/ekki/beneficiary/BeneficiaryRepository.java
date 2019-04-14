package com.ekki.beneficiary;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Integer> {
    @Query("SELECT b FROM Beneficiary b WHERE user_id = ?1 ORDER BY created_at DESC")
    public Iterable<Beneficiary> findAll(int userId);

    @Modifying
    @Query("UPDATE Beneficiary SET balance = ?1 WHERE id = ?2")
    public Integer updateBeneficiaryBalance(double balance, int beneficiaryId);
}