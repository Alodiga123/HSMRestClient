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
public class IBMOfSetResponse  extends GeneralResponse{

    private String IBMOfSetResponse;

    public IBMOfSetResponse(String responseCode, String responseMessage, String IBMOfSetResponse) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.IBMOfSetResponse = IBMOfSetResponse;
    }

	public String getIBMOfSetResponse() {
		return IBMOfSetResponse;
	}

	public void setIBMOfSetResponse(String iBMOfSetResponse) {
		IBMOfSetResponse = iBMOfSetResponse;
	}

    
}
