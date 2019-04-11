package com.ekki.user;

import org.springframework.data.repository.CrudRepository;
import com.ekki.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {}