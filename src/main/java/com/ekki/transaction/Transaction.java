package com.ekki.transaction;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ekki.beneficiary.Beneficiary;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;
    
    @NotNull
    @Column(name = "transaction_user_id")
    private Integer transactionUserId;
    
    @NotNull(message = "{transaction.beneficiaryId.notNull}")
    @Column(name = "transaction_beneficiary_id")
    private Integer transactionBeneficiaryId;
    
    @NotNull(message = "{transaction.amount.notEmpty}")
    private Double transactionAmount;
    
    @Column(name = "transaction_created_at")
    private LocalDateTime transactionCreatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "transaction_beneficiary_id", insertable = false, updatable = false)
    private Beneficiary beneficiary;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionUserId() {
        return transactionUserId;
    }

    public void setTransactionUserId(Integer transactionUserId) {
        this.transactionUserId = transactionUserId;
    }

    public Integer getTransactionBeneficiaryId() {
        return transactionBeneficiaryId;
    }

    public void setTransactionBeneficiaryId(Integer transactionBeneficiaryId) {
        this.transactionBeneficiaryId = transactionBeneficiaryId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionCreatedAt() {
        return transactionCreatedAt;
    }

    public void setTransactionCreatedAt(LocalDateTime transactionCreatedAt) {
        this.transactionCreatedAt = transactionCreatedAt;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}