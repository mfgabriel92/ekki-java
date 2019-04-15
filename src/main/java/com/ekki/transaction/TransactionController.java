package com.ekki.transaction;

import javax.validation.Valid;

import com.ekki.NotFoundException;
import com.ekki.beneficiary.BeneficiaryRepository;
import com.ekki.history.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/transfers")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/")
    public Transaction addTransfer(@Valid @RequestBody Transaction transaction) {
        if (!transactionRepository.hasBeneficiaryWithId(transaction.getBeneficiaryId())) {
            throw new NotFoundException("Beneficiary does not exist");
        }

        Transaction newTransfer = transactionRepository.save(transaction);

        try {
            beneficiaryRepository.updateBeneficiaryBalance(newTransfer.getAmount(), newTransfer.getBeneficiaryId());
            historyRepository.insertHistory(newTransfer.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return newTransfer;
    }
}