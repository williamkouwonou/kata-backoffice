/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.resources;

import com.bank.katabackoffice.dto.TransactionDTO;
import com.bank.katabackoffice.exceptions.KataValidationException;
import com.bank.katabackoffice.exceptions.KataValidationMessage;
import com.bank.katabackoffice.services.ItransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author william
 */
@RestController
@RequestMapping("/api/v1/account")
public class TransactionResource {

    private final ItransactionService transactionService;

    public TransactionResource(ItransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit/{accountId}")
    public ResponseEntity<Object> toDepost(@RequestBody TransactionDTO dto, @PathVariable("accountId") String accountId) {
      
        System.out.println("************************************ "+dto.getAmount());
  try {
            return ResponseEntity.ok(transactionService.toDeposit(accountId, dto.getAmount()));
        } catch (KataValidationException e) {
            return ResponseEntity.badRequest().body(new KataValidationMessage(e.getMessage(), e.getReasonCodes()));
        }

    }

    @PostMapping("/withdrawal/{accountId}")
    public ResponseEntity<Object> toWithdrawal(@RequestBody TransactionDTO dto, @PathVariable("accountId") String accountId) {
        try {
        System.out.println("************************************ "+dto.getAmount());

            return ResponseEntity.ok(transactionService.toWithdrawal(accountId, dto.getAmount()));
        } catch (KataValidationException e) {
            return ResponseEntity.badRequest().body(new KataValidationMessage(e.getMessage(), e.getReasonCodes()));
        }

    }

    @GetMapping("/operations/{accountId}")
    public ResponseEntity<Object> getOperations(@PathVariable("accountId") String accountId) {

        return ResponseEntity.ok(transactionService.getTransactions(accountId));

    }
    @GetMapping("findAll")
    public ResponseEntity<Object> getAllAccount() {

        return ResponseEntity.ok(transactionService.getAllAccount());

    }
}
