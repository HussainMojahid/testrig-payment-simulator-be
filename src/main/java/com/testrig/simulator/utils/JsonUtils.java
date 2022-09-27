package com.testrig.simulator.utils;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static Object readJson() {
		Object pojo = null;
		try {
			pojo = new ObjectMapper().readValue(new ClassPathResource("./response/payment-response.json").getFile(),
					Object.class);
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
