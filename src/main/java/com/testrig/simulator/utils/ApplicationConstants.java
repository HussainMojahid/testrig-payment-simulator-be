package com.testrig.simulator.utils;

public interface ApplicationConstants {

	public static final String CURRENCY_NOT_VALID_STATUS = "422";
	public static final String CURRENCY_NOT_VALID_ERROR_CODE = "138";
	public static final String CURRENCY_NOT_VALID_ERROR_TYPE = "validation";
	public static final String CURRENCY_NOT_VALID_MESSAGE = "Field 'currency' is not valid. Reason: The provided currency is not supported.";
	
	
	public static final String PAYMENT_METHOD_NOT_VALID_STATUS = "400";
	public static final String PAYMENT_METHOD_NOT_VALID_ERROR_CODE = "702";
	public static final String PAYMENT_METHOD_NOT_VALID_ERROR_TYPE = "validation";
	public static final String PAYMENT_METHOD_NOT_VALID_MESSAGE = "Structure of PaymentDetails contains the following unknown fields: [number, cvc, holderName, expiryMonth, expiryYear, type]";
	
	public static final String CVC_NOT_VALID_STATUS = "422";
	public static final String CVC_NOT_VALID_ERROR_CODE = "103";
	public static final String CVC_NOT_VALID_ERROR_TYPE = "validation";
	public static final String CVC_NOT_VALID_MESSAGE = "CVC is not the right length";
	
	public static final String CARD_NUMBER_NOT_VALID_STATUS = "422";
	public static final String CARD_NUMBER_NOT_VALID_ERROR_CODE = "101";
	public static final String CARD_NUMBER_NOT_VALID_ERROR_TYPE = "validation";
	public static final String CARD_NUMBER_NOT_VALID_MESSAGE = "Invalid card number";
	
	public static final String CARD_EXPIRY_PSP_REFERENCE = "CN6S26C2VSGLNK82";
	public static final String CARD_EXPIRY_REFUSAL_REASON = "Expired Card";
	public static final String CARD_EXPIRY_RESULT_CODE = "Refused";
	public static final String CARD_EXPIRY_REFUSAL_REASON_CODE = "6";
	
}
