package com.ekki.transfer;

import javax.validation.Valid;

import com.ekki.NotFoundException;
import com.ekki.beneficiary.BeneficiaryRepository;

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
    private TransferRepository transferRepository;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @PostMapping("/")
    public Transfer addTransfer(@Valid @RequestBody Transfer transfer) {
        if (!transferRepository.hasBeneficiaryWithId(transfer.getBeneficiaryId())) {
            throw new NotFoundException("Beneficiary does not exist");
        }

        Transfer t = transferRepository.save(transfer);

        beneficiaryRepository.updateBeneficiaryBalance(t.getAmount(), t.getBeneficiaryId());

        return t;
    }
}