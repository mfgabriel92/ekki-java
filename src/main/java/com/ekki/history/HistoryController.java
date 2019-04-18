package com.ekki.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/histories")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryController {
    @Autowired
    private HistoryRepository repository;

    @GetMapping("")
    public Iterable<History> fetchAll(@RequestParam int userId) {
        return repository.findAll(userId);
    }
}