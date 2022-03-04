///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.bank.katabackoffice;
//
//import com.bank.katabackoffice.dto.AccountDto;
//import com.bank.katabackoffice.dto.TransactionDTO;
//import com.bank.katabackoffice.modeles.Transaction;
//import java.math.BigDecimal;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import static org.assertj.core.api.Assertions.assertThat;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
///**
// *
// * @author william
// */
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class HttpRequestTest {
//
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void getAllAccount() throws Exception {
//        assertThat(!this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/account/findAll",
//                List.class).isEmpty());
//    }
//
//    @Test
//    public void toDeposit() throws Exception {
//      
//    String accountId="536f6bd4-d094-452d-b7c1-9248dd37eaf0";
//            TransactionDTO t = new TransactionDTO();
//            t.setAmount(BigDecimal.valueOf(2000000));
//
//            HttpEntity<TransactionDTO> entity = new HttpEntity<>(t);
//            ResponseEntity<Transaction> resp = this.restTemplate.exchange("http://localhost:" + port + "/api/v1/account/deposit" + accountId ,
//                    HttpMethod.POST, entity,
//                    Transaction.class);
//
//            assertThat(resp.getStatusCode() == HttpStatus.OK);
//     
//
//    }
//    @Test
//    public void toWithdrawal() throws Exception {
//     String accountId="536f6bd4-d094-452d-b7c1-9248dd37eaf0";
//            TransactionDTO t = new TransactionDTO();
//            HttpEntity<TransactionDTO> entity = new HttpEntity<>(t);
//            t.setAmount(BigDecimal.valueOf(2000000));
//            ResponseEntity<Transaction> resp = this.restTemplate.exchange("http://localhost:" + port + "/api/v1/account/withdrawal" + accountId ,
//                    HttpMethod.POST, entity,
//                    Transaction.class);
//
//            assertThat(resp.getStatusCode() == HttpStatus.OK);
//    }
//}
