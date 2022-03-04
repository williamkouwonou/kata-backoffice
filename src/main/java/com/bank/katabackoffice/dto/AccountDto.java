/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.dto;

import java.math.BigDecimal;

/**
 *
 * @author william
 */
public class AccountDto {

    private String id;
    private BigDecimal balance;
    private String accountNumber;
    private String clientName;

    public AccountDto() {
    }

    public AccountDto(String id, String accountNumber, String firstName, String lastName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.clientName = firstName + " " + lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "id: " + id + ", clientName: " + clientName + " , accountNumber: " + accountNumber + ", balance: " + balance;
    }

}
