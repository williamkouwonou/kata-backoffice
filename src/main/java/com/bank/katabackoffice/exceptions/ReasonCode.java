/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.exceptions;

/**
 *
 * @author william
 */
public class ReasonCode {
    private String code;
   private String message;

    public ReasonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReasonCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
