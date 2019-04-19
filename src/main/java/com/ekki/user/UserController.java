package com.ekki.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    private UserRepository repository;

    /**
     * Fetches the information of the logged in {@link User}
     * 
     * @return the user's information
     */
    @GetMapping("me")
    public User me() {
        Optional<User> ouser = repository.findById(1);
        return ouser.get();
    }
}