package com.testrig.simulator.service;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.testrig.simulator.response.PaymentErrorResponse;
import com.testrig.simulator.response.PaymentSuccessResponse;

public interface CommonService {
	public boolean validatePaymentMethod(String paymentMethod);
	public boolean validateCurrency(String currency);
	public boolean validateCvc(String cvc);
	public boolean validateCardNumber(String cardNumber);
	
	public PaymentSuccessResponse generatePaymentSuccessResponse(JSONObject jsonObject) throws Exception;
	public PaymentErrorResponse generatePaymentMethodErrorResponse();
	public PaymentErrorResponse generateCurrencyErrorResponse();
	public PaymentErrorResponse generateCvcErrorResponse();
	public PaymentErrorResponse generateCardNumberErrorResponse();
}
