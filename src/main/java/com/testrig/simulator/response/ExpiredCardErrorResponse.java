package com.testrig.simulator.response;

public class ExpiredCardErrorResponse {

	private AdditionalDataResponse additionalData;
	private String pspReference;
	private String refusalReason;
	private String resultCode;
	private String refusalReasonCode;
	private String merchantReference;
	
	public ExpiredCardErrorResponse(AdditionalDataResponse additionalData, String pspReference, String refusalReason,
			String resultCode, String refusalReasonCode, String merchantReference) {
		super();
		this.additionalData = additionalData;
		this.pspReference = pspReference;
		this.refusalReason = refusalReason;
		this.resultCode = resultCode;
		this.refusalReasonCode = refusalReasonCode;
		this.merchantReference = merchantReference;
	}
	
	public AdditionalDataResponse getAdditionalData() {
		return additionalData;
	}
	public void setAdditionalData(AdditionalDataResponse additionalData) {
		this.additionalData = additionalData;
	}
	public String getPspReference() {
		return pspReference;
	}
	public void setPspReference(String pspReference) {
		this.pspReference = pspReference;
	}
	public String getRefusalReason() {
		return refusalReason;
	}
	public void setRefusalReason(String refusalReason) {
		this.refusalReason = refusalReason;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getRefusalReasonCode() {
		return refusalReasonCode;
	}
	public void setRefusalReasonCode(String refusalReasonCode) {
		this.refusalReasonCode = refusalReasonCode;
	}
	public String getMerchantReference() {
		return merchantReference;
	}
	public void setMerchantReference(String merchantReference) {
		this.merchantReference = merchantReference;
	}
	
	
}