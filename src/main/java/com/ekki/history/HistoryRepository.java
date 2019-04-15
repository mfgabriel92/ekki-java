package com.ekki.history;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HistoryRepository extends CrudRepository<History, Integer> {
    @Query("SELECT COUNT(id) > 0 FROM Transaction WHERE id = ?1")
    public Boolean hasTransferWithId(int id);

    @Modifying
    @Query(value = "INSERT INTO histories (transfer_id) VALUES (?1)", nativeQuery = true)
    public Integer insertHistory(int transferId);
}