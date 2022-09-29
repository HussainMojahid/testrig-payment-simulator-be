package com.testrig.simulator.response;

import java.util.Objects;

public class PaymentSuccessResponse {
	
	private AdditionalDataResponse additionalData;
	private String pspReference;
	private String resultCode;
	private AmountResponse amount;
	private String merchantReference;
	private PaymentMethodResponse paymentMethod;

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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public AmountResponse getAmount() {
		return amount;
	}

	public void setAmount(AmountResponse amount) {
		this.amount = amount;
	}

	public String getMerchantReference() {
		return merchantReference;
	}

	public void setMerchantReference(String merchantReference) {
		this.merchantReference = merchantReference;
	}

	public PaymentMethodResponse getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodResponse paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalData, amount, merchantReference, paymentMethod, pspReference, resultCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentSuccessResponse other = (PaymentSuccessResponse) obj;
		return Objects.equals(additionalData, other.additionalData) && Objects.equals(amount, other.amount)
				&& Objects.equals(merchantReference, other.merchantReference)
				&& Objects.equals(paymentMethod, other.paymentMethod)
				&& Objects.equals(pspReference, other.pspReference) && Objects.equals(resultCode, other.resultCode);
	}

}