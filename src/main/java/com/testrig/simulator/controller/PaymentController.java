package com.testrig.simulator.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testrig.simulator.service.CommonService;
import com.testrig.simulator.utils.DateUtil;
import com.testrig.simulator.utils.JsonUtils;

@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	private CommonService commonService;

	@GetMapping("/test")
	public Object test() throws JSONException {
		return JsonUtils.readPaymentSuccessResponseJson();
	}
	
	@PostMapping("/payments")
	public Object payment(@RequestBody Object requestObject) throws Exception {
		String reqJsonString = JsonUtils.objectToJsonString(requestObject);
		JSONObject reqJsonObject= new JSONObject(reqJsonString);

		boolean isPaymentMethodValid = commonService.validatePaymentMethod(reqJsonObject.getJSONObject("paymentMethod").getString("type"));
		if(!isPaymentMethodValid) {
			return commonService.generatePaymentMethodErrorResponse();
		} else if (!commonService.validateCurrency(reqJsonObject.getJSONObject("amount").getString("currency"))) {
			return commonService.generateCurrencyErrorResponse();
		} else if (!commonService.validateCvc(reqJsonObject.getJSONObject("paymentMethod").getString("cvc"))) {
			return commonService.generateCvcErrorResponse();
		} else if (!commonService.validateCardNumber(reqJsonObject.getJSONObject("paymentMethod").getString("number"))) {
			return commonService.generateCardNumberErrorResponse();
		} else if (!commonService.validateCardExpiry(reqJsonObject)) {
			return commonService.generateExpiredCardErrorResponse(reqJsonObject);
		}
		return commonService.generatePaymentSuccessResponse(reqJsonObject);
	}
	
}
