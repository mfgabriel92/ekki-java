package com.ekki.beneficiary;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/beneficiaries")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryRepository repository;

    @GetMapping("")
    public Iterable<Beneficiary> fetchAll(@RequestParam int userId) {
        return repository.findAll(userId);
    }

    @PostMapping("")
    public Beneficiary addBeneficiary(@Valid @RequestBody Beneficiary beneficiary) {
        return repository.save(beneficiary);
    }
}