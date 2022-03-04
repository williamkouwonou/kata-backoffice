/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.services;

import com.bank.katabackoffice.dto.AccountDto;
import com.bank.katabackoffice.dto.TransactionDTO;
import com.bank.katabackoffice.exceptions.KataValidationException;
import com.bank.katabackoffice.exceptions.ReasonCode;
import com.bank.katabackoffice.modeles.Account;
import com.bank.katabackoffice.modeles.Transaction;
import com.bank.katabackoffice.modeles.TransactionType;
import com.bank.katabackoffice.repositories.AccountRepository;
import com.bank.katabackoffice.repositories.TransactionRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author william
 */
@Service
public class TransactionService implements ItransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction toDeposit(String accountId, BigDecimal amount) {
        return this.saveTransaction(TransactionType.D, accountId, amount);
    }

    @Override
    public Transaction toWithdrawal(String accountId, BigDecimal amount) {
        return this.saveTransaction(TransactionType.W, accountId, amount);

    }

    /**
     * @param transactionType Deposit or Withdrawal
     * @param accountId client identity
     * @param amount amount of the transaction
     * @return persist transaction
     */
    private Transaction saveTransaction(TransactionType transactionType, String accountId, BigDecimal amount) {
        List<ReasonCode> reasonCodes = new ArrayList<>();
        Transaction transaction = new Transaction();
        Optional<Account> account = accountRepository.findById(accountId);
        if (accountId == null || !account.isPresent()) {
            reasonCodes.add(new ReasonCode("transaction.account", "the account does not exist"));
            throw new KataValidationException(reasonCodes, "Error during operation");

        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            reasonCodes.add(new ReasonCode("transaction.amount", "The amount is not valid"));
            throw new KataValidationException(reasonCodes, "Error during operation");

        }
        if (transactionType == TransactionType.W && getBalance(accountId).compareTo(amount) <0) {
            reasonCodes.add(new ReasonCode("transaction.balance", "Insufficient account balance"));
            throw new KataValidationException(reasonCodes, "Error during operation");
        }
        transaction.setAccount(account.get());
        transaction.setAmount(amount);
        transaction.setTransactionType(transactionType);

        transaction = transactionRepository.saveAndFlush(transaction);

        System.out.println("************************* "+transaction);
        return transaction;
    }

    @Override
    public BigDecimal getBalance(String accountId) {
        Optional<BigDecimal> deposit = transactionRepository.findBalanceByTransactionType(TransactionType.D, accountId);
        Optional<BigDecimal> withdrawal = transactionRepository.findBalanceByTransactionType(TransactionType.W, accountId);

        if (deposit.isPresent() && withdrawal.isPresent()) {
            return deposit.get().add(withdrawal.get().negate());
        }
        if (deposit.isPresent() && !withdrawal.isPresent()) {
            return deposit.get();
        }

        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getBalance(String accountId, Instant date) {
        Optional<BigDecimal> deposit = transactionRepository.findBalanceByTransactionType(TransactionType.D, accountId, date);
        Optional<BigDecimal> withdrawal = transactionRepository.findBalanceByTransactionType(TransactionType.W, accountId, date);

        if (deposit.isPresent() && withdrawal.isPresent()) {
            return deposit.get().add(withdrawal.get().negate());
        }
        if (deposit.isPresent() && !withdrawal.isPresent()) {
            return deposit.get();
        }

        return BigDecimal.ZERO;
    }

    @Override
    public List<TransactionDTO> getTransactions(String accountId) {
        List<TransactionDTO> transactions = transactionRepository.findByAccount(accountId);

        transactions.stream().forEach(t -> {
            t.setBalance(this.getBalance(accountId, t.getDate()));
        });
        return transactions;
    }
    @Override
    public   List<AccountDto> getAllAccount(){
        List<AccountDto> accountDtos = accountRepository.findAllAccount();

        accountDtos.stream().forEach(t -> {
            t.setBalance(this.getBalance(t.getId()));
        });
        return accountDtos;
    }
}
