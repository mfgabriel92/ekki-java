package com.ekki.transfer;

import javax.validation.Valid;

import com.ekki.beneficiary.BeneficiaryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/transfers")
@CrossOrigin(origins = "http://localhost:3000")
public class TransferController {
    @Autowired
    private TransferRepository repository;

    @PostMapping("/")
    public Transfer addTransfer(@Valid @RequestBody Transfer transfer) {
        if (!repository.hasBeneficiaryWithId(transfer.getBeneficiaryId())) {
            throw new BeneficiaryNotFoundException("Beneficiary does not exist");
        }

        return repository.save(transfer);
    }
}