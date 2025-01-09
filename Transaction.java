package com.example.springboot;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_holder_id", nullable = false)
    @JsonBackReference
    private AccountHolder accountHolder;

    @Column(nullable = false)
    private String header;

    @Column(name = "txn_date", nullable = false)
    private LocalDate txnDate;

    @Column
    private Double credit;

    @Column
    private Double debit;

    // Constructors
    public Transaction() {
    }

    public Transaction(AccountHolder accountHolder, String header, LocalDate txnDate, Double credit, Double debit) {
        this.accountHolder = accountHolder;
        this.header = header;
        this.txnDate = txnDate;
        this.credit = credit;
        this.debit = debit;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public LocalDate getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(LocalDate txnDate) {
        this.txnDate = txnDate;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }
}

