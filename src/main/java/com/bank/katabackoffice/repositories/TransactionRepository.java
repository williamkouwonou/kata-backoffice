/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.repositories;

import com.bank.katabackoffice.dto.TransactionDTO;
import com.bank.katabackoffice.modeles.Transaction;
import com.bank.katabackoffice.modeles.TransactionType;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author william
 */
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("SELECT new com.bank.katabackoffice.dto.TransactionDTO(t.transactionType,t.amount,t.transactionDate) "
            + " FROM Transaction t WHERE t.account.id=:aid ORDER BY t.transactionDate DESC")
    public List<TransactionDTO> findByAccount(@Param("aid") String accountId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.account.id=:aid AND t.transactionType=:ttype")
    public Optional<BigDecimal> findBalanceByTransactionType(@Param("ttype") TransactionType t, @Param("aid") String accountId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.account.id=:aid AND t.transactionType=:ttype AND t.transactionDate<=:date")
    public Optional<BigDecimal> findBalanceByTransactionType(@Param("ttype") TransactionType t, @Param("aid") String accountId, @Param("date") Instant date);
}
