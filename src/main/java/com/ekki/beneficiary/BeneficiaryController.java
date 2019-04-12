package com.ekki.beneficiary;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/beneficiary")
@CrossOrigin(origins = "http://localhost:3000")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryRepository repository;

    @PostMapping("/")
    public Beneficiary addBeneficiary(@Valid @RequestBody Beneficiary beneficiary) {
        return repository.save(beneficiary);
    }
}