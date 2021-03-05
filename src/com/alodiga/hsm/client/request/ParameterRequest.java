/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alodiga.hsm.client.request;

/**
 *
 * @author YAlmea
 */
public class ParameterRequest {
    
    
	public String getHSMStatus(String cardId) {
		
		String params = "cardId="+ cardId ;
		return params;
	}
	
	
	public String getVerifyVisaCVVRequest(String cvv, String pan, String cvvType, String expirationDate, String servicesCode, String institutionId) {
	        
    	 String params = "cvv="+ cvv +
                 "&pan=" + pan +
                 "&cvvType=" + cvvType +
                 "&pan=" + pan +
                 "&expirationDate=" + expirationDate +
                 "&servicesCode=" + servicesCode +
                 "&institutionId=" + institutionId;
    	 return params;
    }
	 
	
    public String getARPCRequest (String institutionId, String oPMode, String schemeEMV, String pan,
            String seqNumber, String atc, String unpredictableNumber, String transactionData, String arqc){
        
        String params = "institutionId="+ institutionId +
                "&oPMode=" + oPMode +
                "&schemeEMV=" + schemeEMV +
                "&pan=" + pan +
                "&seqNumber=" + seqNumber +
                "&atc=" + atc +
                "&unpredictableNumber=" + unpredictableNumber +
                "&transactionData=" + transactionData +
                "&arqc=" + arqc;
        
        return params;
    }
  
    
    public String getGenerateIBMPinOffSet(String pinELMK, String pan, String institutionId, String typeOffProduct) {
        
   	 	String params = "pinELMK="+ pinELMK +
                "&pan=" + pan +
                "&institutionId=" + institutionId +
                "&typeOffProduct=" + typeOffProduct;
   	 	return params;
    } 
    
    
    public String getTranslatePINFromKWPtoMFK(String terminalId, String pinBlock, String pan) {
        
   	 	String params = "terminalId="+ terminalId +
                "&pinBlock=" + pinBlock +
                "&pan=" + pan;
   	 	return params;
    }
    
    
    public String getGenerateVISAOffSet(String pin, String pan) {
        
   	 	String params = "pin="+ pin +
                "&pan=" + pan;
   	 	return params;
    }
    
    
    public String getCheckDigitValueRequest(String terminalId) {
        
        String params = "terminalId="+ terminalId ;
        return params;
    }
    
    
    public String getVerifyPinUsingVISAMethodRequest(String terminalId, String pinBlock, String pan, String Offset) {
        
        String params = "terminalId="+ terminalId +
                "&pinBlock=" + pinBlock +
                "&pan=" + pan +
                "&Offset=" + Offset;
        return params;
    }
    
    
    public String getVerifyPinUsingIBMMethodRequest(String terminalId, String pinBlock, String pan, String Offset) {
        
        String params = "terminalId="+ terminalId +
                "&pinBlock=" + pinBlock +
                "&pan=" + pan +
                "&Offset=" + Offset;
        return params;
    }
    
    
}
