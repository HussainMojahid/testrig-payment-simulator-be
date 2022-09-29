package com.testrig.simulator.response;

public class PaymentErrorResponse {
	private String status;
	private String errorCode;
	private String message;
	private String errorType;
	private String pspReference = "FWF2Q3HDGQRXGN82";
	
	public PaymentErrorResponse(String status, String errorCode, String message, String errorType) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.errorType = errorType;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getPspReference() {
		return pspReference;
	}
	public void setPspReference(String pspReference) {
		this.pspReference = pspReference;
	}
	
	

}
