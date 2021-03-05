/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alodiga.hsm.client.response;

/**
 *
 * @author YAlmea
 */
public class VerifyPinUsingIBMMethodResponse  extends GeneralResponse{

    private String verificationValue;

    public VerifyPinUsingIBMMethodResponse(String responseCode, String responseMessage, String verificationValue) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.verificationValue = verificationValue;
    }

    public String getVerificationValue() {
        return verificationValue;
    }

    public void setVerificationValue(String verificationValue) {
        this.verificationValue = verificationValue;
    }
}
