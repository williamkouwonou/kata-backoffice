/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.repositories;

import com.bank.katabackoffice.dto.AccountDto;
import com.bank.katabackoffice.modeles.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author william
 */
public interface AccountRepository  extends JpaRepository<Account, String>{
    
@Query("SELECT new com.bank.katabackoffice.dto.AccountDto(a.id,a.accountNumber,a.client.firstName,a.client.lastName) "
 + " FROM Account a ")
    public List<AccountDto> findAllAccount();
}
