package com.ekki.history;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HistoryRepository extends CrudRepository<History, Integer> {
    @Query(value = "SELECT h.* FROM histories h, transactions t WHERE h.transaction_id = t.id AND t.user_id = ?1", nativeQuery = true)
    public Iterable<History> findAll(int userId);

    @Modifying
    @Query(value = "INSERT INTO histories (transaction_id) VALUES (?1)", nativeQuery = true)
    public Integer insertHistory(int transferId);
}