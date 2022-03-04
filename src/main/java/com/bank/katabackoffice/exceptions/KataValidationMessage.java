/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.katabackoffice.exceptions;

import java.util.List;

/**
 *
 * @author william
 */
public class KataValidationMessage {
     private String message;

        private List<ReasonCode> reasonCodes;

    public KataValidationMessage(String message, List<ReasonCode> reasonCodes) {
        this.message = message;
        this.reasonCodes = reasonCodes;
    }

    public List<ReasonCode> getReasonCodes() {
        return reasonCodes;
    }

    public void setReasonCodes(List<ReasonCode> reasonCodes) {
        this.reasonCodes = reasonCodes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
