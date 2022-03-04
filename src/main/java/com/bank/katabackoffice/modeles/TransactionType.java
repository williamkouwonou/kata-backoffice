/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.modeles;

/**
 *
 * @author william
 */
public enum TransactionType {
    D,W;
@Override
public String toString(){
    switch (this) {
        case D:
             return "Deposit";
        default:
             return "Withdrawal";
    }
}
}
