package com.ekki.history;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Integer> {
    @Query("SELECT COUNT(id) > 0 FROM Transfer WHERE id = ?1")
    public Boolean hasTransferWithId(int id);
}