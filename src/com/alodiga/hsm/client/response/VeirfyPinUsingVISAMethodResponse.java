package com.alodiga.hsm.client.response;

public class VeirfyPinUsingVISAMethodResponse extends GeneralResponse {

	private String verificationValue;

	public VeirfyPinUsingVISAMethodResponse(String responseCode,String responseMessage, String name) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.verificationValue = name;
	}

	public String getVerificationValue() {
		return verificationValue;
	}

	public void setVerificationValue(String verificationValue) {
		this.verificationValue = verificationValue;
	}

}
