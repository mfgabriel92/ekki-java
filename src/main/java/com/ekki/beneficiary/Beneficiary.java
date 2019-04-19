package com.ekki.beneficiary;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ekki.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiary_id")
    private Integer beneficiaryId;
    
    @NotNull
    @Column(name = "beneficiary_user_id")
    private Integer beneficiaryUserId;
    
    @NotEmpty(message = "{beneficiary.name.notEmpty}")
    @Column(name = "beneficiary_name")
    private String beneficiaryName;
    
    @NotEmpty(message = "{beneficiary.accountNumber.notEmpty}")
    @Column(name = "beneficiary_account_number")
    private String beneficiaryAccountNumber;
    
    @NotEmpty(message = "{beneficiary.agency.notEmpty}")
    @Column(name = "beneficiary_agency")
    private String beneficiaryAgency;
    
    @NotEmpty(message = "{beneficiary.bankName.notEmpty}")
    @Column(name = "beneficiary_bank_name")
    private String beneficiaryBankName;
    
    @NotEmpty(message = "{beneficiary.city.notEmpty}")
    @Column(name = "beneficiary_city")
    private String beneficiaryCity;
    
    @NotEmpty(message = "{beneficiary.state.notEmpty}")
    @Column(name = "beneficiary_state")
    private String beneficiaryState;

    @Column(name = "beneficiary_balance")
    private Double beneficiaryBalance = 0d;
    
    @Column(name = "beneficiary_created_at")
    private LocalDateTime beneficiaryCreatedAt = LocalDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "beneficiary")
    private Set<Transaction> transactions = new HashSet<>();

    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Integer beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Integer getBeneficiaryUserId() {
        return beneficiaryUserId;
    }

    public void setBeneficiaryUserId(Integer beneficiaryUserId) {
        this.beneficiaryUserId = beneficiaryUserId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getBeneficiaryAgency() {
        return beneficiaryAgency;
    }

    public void setBeneficiaryAgency(String beneficiaryAgency) {
        this.beneficiaryAgency = beneficiaryAgency;
    }

    public String getBeneficiaryBankName() {
        return beneficiaryBankName;
    }

    public void setBeneficiaryBankName(String beneficiaryBankName) {
        this.beneficiaryBankName = beneficiaryBankName;
    }

    public String getBeneficiaryCity() {
        return beneficiaryCity;
    }

    public void setBeneficiaryCity(String beneficiaryCity) {
        this.beneficiaryCity = beneficiaryCity;
    }

    public String getBeneficiaryState() {
        return beneficiaryState;
    }

    public void setBeneficiaryState(String beneficiaryState) {
        this.beneficiaryState = beneficiaryState;
    }

    public Double getBeneficiaryBalance() {
        return beneficiaryBalance;
    }

    public void setBeneficiaryBalance(Double beneficiaryBalance) {
        this.beneficiaryBalance = beneficiaryBalance;
    }

    public LocalDateTime getBeneficiaryCreatedAt() {
        return beneficiaryCreatedAt;
    }

    public void setBeneficiaryCreatedAt(LocalDateTime beneficiaryCreatedAt) {
        this.beneficiaryCreatedAt = beneficiaryCreatedAt;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}