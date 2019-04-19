package com.ekki.transaction;

import java.util.Optional;

import javax.validation.Valid;

import com.ekki.NotFoundException;
import com.ekki.beneficiary.BalanceLimitReachedException;
import com.ekki.beneficiary.Beneficiary;
import com.ekki.beneficiary.BeneficiaryRepository;
import com.ekki.user.InsufficientBalanceException;
import com.ekki.user.User;
import com.ekki.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    /**
     * Fetch all of the {@link Transaction} of the logged-in {@link User}
     * 
     * @param userId int id of the logged in user
     * @return a set of transactions
     */
    @GetMapping("")
    public Iterable<Transaction> fetchAll(@RequestParam int userId) {
        return transactionRepository.findAll(userId);
    }

    /**
     * Makes a new transaction for the chosen {@link Beneficiary}
     * 
     * @param transaction the data of the new {@link Transaction} to be created
     * @return the created transaction
     */
    @PostMapping("")
    public Transaction addTransfer(@Valid @RequestBody Transaction transaction) {
        Optional<Beneficiary> beneficiary = beneficiaryRepository.findById(transaction.getTransactionBeneficiaryId());
        
        if (!beneficiary.isPresent()) {
            throw new NotFoundException("Beneficiary does not exist");
        }

        Optional<User> user = userRepository.findById(transaction.getTransactionUserId());
        Double userNewBalance = (user.get().getUserBalance() - transaction.getTransactionAmount());

        if (userNewBalance < 0) {
            throw new InsufficientBalanceException("Saldo insuficiente");
        }

        Double beneficiaryNewBalance = (beneficiary.get().getBeneficiaryBalance() + transaction.getTransactionAmount());

        if (beneficiaryNewBalance > 500) {
            throw new BalanceLimitReachedException("Limite de R$ 500,00 para o beneficiário excedido");
        }
        
        beneficiary.get().setBeneficiaryBalance(beneficiaryNewBalance);
        user.get().setUserBalance(userNewBalance);

        return transactionRepository.save(transaction);
    }
}