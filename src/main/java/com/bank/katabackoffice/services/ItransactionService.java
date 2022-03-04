/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.services;

import com.bank.katabackoffice.dto.AccountDto;
import com.bank.katabackoffice.dto.TransactionDTO;
import com.bank.katabackoffice.modeles.Transaction;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author william
 */
public interface ItransactionService {
    
 public Transaction toDeposit(String accountId, BigDecimal amount);
 public Transaction toWithdrawal(String accountId, BigDecimal amount);
 public List<TransactionDTO> getTransactions(String accountId);
 public List<AccountDto> getAllAccount();

 public BigDecimal getBalance(String accountId);
 public BigDecimal getBalance(String accountId,Instant date);

}
