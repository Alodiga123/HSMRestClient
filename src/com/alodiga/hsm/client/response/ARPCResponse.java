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
public class ARPCResponse extends GeneralResponse {

    private String arpc;

    public ARPCResponse(String responseCode, String responseMessage, String name) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.arpc = name;
    }

    public String getArpc() {
        return arpc;
    }

    public void setArpc(String arpc) {
        this.arpc = arpc;
    }

}
