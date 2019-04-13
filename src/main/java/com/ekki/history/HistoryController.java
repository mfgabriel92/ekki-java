package com.ekki.history;

import javax.validation.Valid;

import com.ekki.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/histories")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryController {
    @Autowired
    private HistoryRepository repository;

    @GetMapping("/")
    public Iterable<History> fetchAll() {
        return repository.findAll();
    }

    @PostMapping("/")
    public History addHistory(@Valid @RequestBody History history) {
        if (!repository.hasTransferWithId(history.getTransferId())) {
            throw new NotFoundException("Transfer does not exist");
        }

        return repository.save(history);
    }
}