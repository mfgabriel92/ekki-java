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

    /**
     * Fetch all of the {@link Beneficiary} of the logged-in {@link User}
     * 
     * @param userId the id of the logged-in {@link User}
     * @return the user's {@link Beneficiary}
     */
    @GetMapping("")
    public Iterable<Beneficiary> fetchAll(@RequestParam int userId) {
        return repository.findAll(userId);
    }

    /**
     * Creates a new {@link Beneficiary} for the logged in {@link User}
     * 
     * @param beneficiary the data of the new {@link Beneficiary} to be created
     * @return
     */
    @PostMapping("")
    public Beneficiary addBeneficiary(@Valid @RequestBody Beneficiary beneficiary) {
        System.out.println(beneficiary);
        return repository.save(beneficiary);
    }
}