/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.repositories;

import com.bank.katabackoffice.modeles.client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author william
 */
public interface Clientrepository extends JpaRepository<client, String>{
    
}
