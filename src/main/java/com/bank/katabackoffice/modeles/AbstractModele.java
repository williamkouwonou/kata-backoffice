/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.modeles;

import java.util.UUID;
import javax.persistence.PrePersist;

/**
 *
 * @author william
 */
public abstract class AbstractModele {

    abstract void setId(String id);

    @PrePersist
    public void init() {
        this.setId(UUID.randomUUID().toString());
    }
}
