package com.bank.katabackoffice;

import com.bank.katabackoffice.dto.TransactionDTO;
import com.bank.katabackoffice.modeles.Transaction;
import com.bank.katabackoffice.services.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class KataBackofficeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TransactionService transactionService;

    @Test
    void contextLoads() {
    }

    @Test
    public void toDeposit() throws Exception {

        String accountId = "536f6bd4-d094-452d-b7c1-9248dd37eaf0";

        assertThat(transactionService.toDeposit(accountId, new BigDecimal(20000)).getId() != null);
        assertThat(transactionService.toDeposit(accountId, new BigDecimal(30000)).getId() != null);
        assertThat(transactionService.toDeposit(accountId, new BigDecimal(40000)).getId() != null);
        assertThat(transactionService.toDeposit(accountId, new BigDecimal(50000)).getId() != null);
    }

@Test
    public void toWithdrawal() throws Exception {

        String accountId = "536f6bd4-d094-452d-b7c1-9248dd37eaf0";

        assertThat(transactionService.toWithdrawal(accountId, new BigDecimal(10000)).getId() != null);
        assertThat(transactionService.toWithdrawal(accountId, new BigDecimal(20000)).getId() != null);
        assertThat(transactionService.toWithdrawal(accountId, new BigDecimal(40000)).getId() != null);
        assertThat(transactionService.toWithdrawal(accountId, new BigDecimal(3000)).getId() != null);
    }
}
