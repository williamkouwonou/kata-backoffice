/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.dto;

import com.bank.katabackoffice.modeles.TransactionType;
import java.math.BigDecimal;
import java.time.Instant;

/**
 *
 * @author william
 */
public class TransactionDTO {
    private TransactionType transactionType;
    private BigDecimal amount;
    private Instant date;
    private  BigDecimal balance;

    public TransactionDTO(TransactionType transactionType, BigDecimal amount, Instant date) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
    }

    public TransactionDTO() {
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }



}
