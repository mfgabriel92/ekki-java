package com.ekki.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ekki.user.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    @Modifying
    @Query("UPDATE User SET balance = ?1 WHERE id = ?2")
    public Integer updateUserBalance(double balance, int id);
}