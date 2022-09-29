package com.testrig.simulator.service.impl;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.testrig.simulator.response.AdditionalDataResponse;
import com.testrig.simulator.response.AmountResponse;
import com.testrig.simulator.response.PaymentErrorResponse;
import com.testrig.simulator.response.PaymentMethodResponse;
import com.testrig.simulator.response.PaymentSuccessResponse;
import com.testrig.simulator.service.CommonService;
import com.testrig.simulator.utils.ApplicationConstants;
import com.testrig.simulator.utils.JsonUtils;

@Service
public class CommonServiceImpl implements CommonService {

	@Override
	public boolean validatePaymentMethod(String paymentMethod) {
		Object paymentMethodJson = JsonUtils.readPaymentMethodJson();
		String paymentMethodJsonStr = JsonUtils.objectToJsonString(paymentMethodJson);
		JSONObject methodJsonObject = null;
		try {
			methodJsonObject = new JSONObject(paymentMethodJsonStr);

			JSONArray array = methodJsonObject.getJSONArray("paymentMethods");
			for (int i = 0; i < array.length(); i++) {
				System.out.println("methodJsonObject: " + array.optJSONObject(i).get("type"));
				if(paymentMethod.equalsIgnoreCase(array.optJSONObject(i).getString("type"))) {
					return true;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PaymentSuccessResponse generatePaymentSuccessResponse(JSONObject jsonObject) throws Exception {
		PaymentSuccessResponse successResponsse = new PaymentSuccessResponse();
		successResponsse.setMerchantReference(jsonObject.getString("reference"));
		successResponsse.setPspReference("DZMW93JD4VTFWR82");
		successResponsse.setResultCode("Authorised");
		
		AdditionalDataResponse additionalData = new AdditionalDataResponse();
		additionalData.setScaExemptionRequested("transactionRiskAnalysis");
		
		PaymentMethodResponse paymentMethod = new PaymentMethodResponse();
		paymentMethod.setBrand("visa");
		paymentMethod.setType(jsonObject.getJSONObject("paymentMethod").getString("type"));
		
		AmountResponse amount = new AmountResponse();
		amount.setCurrency(jsonObject.getJSONObject("amount").getString("currency"));
		amount.setValue(jsonObject.getJSONObject("amount").getDouble("value"));
		
		successResponsse.setAdditionalData(additionalData);
		successResponsse.setPaymentMethod(paymentMethod);
		successResponsse.setAmount(amount);
		return successResponsse;
	}

	@Override
	public PaymentErrorResponse generatePaymentMethodErrorResponse() {
		return new PaymentErrorResponse(ApplicationConstants.PAYMENT_METHOD_NOT_VALID_STATUS, 
				ApplicationConstants.PAYMENT_METHOD_NOT_VALID_ERROR_CODE, 
				ApplicationConstants.PAYMENT_METHOD_NOT_VALID_MESSAGE,
				ApplicationConstants.PAYMENT_METHOD_NOT_VALID_ERROR_TYPE);
	}

	@Override
	public boolean validateCurrency(String currency) {
		if(currency.isEmpty()) {
			return false;
		} else if (!currency.isEmpty() && currency.length() != 3 ) {
			return false;
		}
		return true;
	}

	@Override
	public PaymentErrorResponse generateCurrencyErrorResponse() {
		return new PaymentErrorResponse(ApplicationConstants.CURRENCY_NOT_VALID_STATUS, 
				ApplicationConstants.CURRENCY_NOT_VALID_ERROR_CODE, 
				ApplicationConstants.CURRENCY_NOT_VALID_MESSAGE, 
				ApplicationConstants.CURRENCY_NOT_VALID_ERROR_TYPE);
	}

	@Override
	public boolean validateCvc(String cvc) {
		if(cvc.isEmpty()) {
			return false;
		} else if (!cvc.isEmpty() && cvc.length() != 3 ) {
			return false;
		}
		return true;
	}

	@Override
	public PaymentErrorResponse generateCvcErrorResponse() {
		return new PaymentErrorResponse(ApplicationConstants.CVC_NOT_VALID_STATUS, 
				ApplicationConstants.CVC_NOT_VALID_ERROR_CODE, 
				ApplicationConstants.CVC_NOT_VALID_MESSAGE, 
				ApplicationConstants.CVC_NOT_VALID_ERROR_TYPE);
	}

	@Override
	public boolean validateCardNumber(String cardNumber) {
		if(cardNumber.isEmpty()) {
			return false;
		} else if (!cardNumber.isEmpty() && cardNumber.length() != 16 ) {
			return false;
		}
		return true;
	}

	@Override
	public PaymentErrorResponse generateCardNumberErrorResponse() {
		return new PaymentErrorResponse(ApplicationConstants.CARD_NUMBER_NOT_VALID_STATUS, 
				ApplicationConstants.CARD_NUMBER_NOT_VALID_ERROR_CODE, 
				ApplicationConstants.CARD_NUMBER_NOT_VALID_MESSAGE, 
				ApplicationConstants.CARD_NUMBER_NOT_VALID_ERROR_TYPE);
	}

}
