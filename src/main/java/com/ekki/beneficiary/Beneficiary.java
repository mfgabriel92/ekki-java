package com.ekki.beneficiary;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "user_id")
    @NotNull
    private Integer userId;
    
    @NotEmpty(message = "{beneficiary.name.notEmpty}")
    private String name;
    
    @Column(name = "account_number")
    @NotEmpty(message = "{beneficiary.accountNumber.notEmpty}")
    private String accountNumber;
    
    @NotEmpty(message = "{beneficiary.agency.notEmpty}")
    private String agency;
    
    @Column(name = "bank_name")
    @NotEmpty(message = "{beneficiary.bankName.notEmpty}")
    private String bankName;
    
    @NotEmpty(message = "{beneficiary.city.notEmpty}")
    private String city;
    
    @NotEmpty(message = "{beneficiary.state.notEmpty}")
    private String state;
    private Double balance;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Beneficiary() {
        this.createdAt = LocalDateTime.now();
        this.balance = 0d;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}