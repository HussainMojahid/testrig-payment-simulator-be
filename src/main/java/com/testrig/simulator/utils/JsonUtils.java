package com.testrig.simulator.utils;

import java.io.IOException;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static Object readPaymentMethodJson() {
		String filePath = "./validation-data/payment-method.json";
		return readJson(filePath);
	}
	
	public static Object readPaymentSuccessResponseJson() {
		String filePath = "./response/payment-success-response.json";
		return readJson(filePath);
	}
	
	public static Object readPaymentErrorResponseJson() {
		String filePath = "./response/payment-error-response.json";
		return readJson(filePath);
	}
	
	private static Object readJson(String filePath) {
		Object pojo = null;
		try {
			pojo = new ObjectMapper().readValue(new ClassPathResource(filePath).getFile(), Object.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("json: " + pojo);
		return pojo;
	}
	
	public static String objectToJsonString(Object object) {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {
			// Converting the Java object into a JSON string
			jsonStr = Obj.writeValueAsString(object);
			// Displaying Java object into a JSON string
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
}
