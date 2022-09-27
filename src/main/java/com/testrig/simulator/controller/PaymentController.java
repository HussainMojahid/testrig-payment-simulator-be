package com.testrig.simulator.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testrig.simulator.utils.JsonUtils;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@GetMapping("/test")
	public Object test() {
		return JsonUtils.readJson();
	}
	
	@PostMapping("/payment")
	public Object payment(@RequestBody Object obj) throws JSONException {
		String str = JsonUtils.objectToJsonString(obj);
		JSONObject jsonObject= new JSONObject(str);
		
		if(jsonObject.has("fname")) {
			System.out.println("property present");	
		} else {
			System.out.println("property not present");
		}
		System.out.println("jsonObject name: "+ jsonObject.get("name"));
		return JsonUtils.readJson();
	}
	
}
