package com.ekki.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ekki.user.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {}