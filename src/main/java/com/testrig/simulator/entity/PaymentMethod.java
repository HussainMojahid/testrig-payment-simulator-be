package com.testrig.simulator.entity;

//@Component
//@PropertySource(value = "classpath:validation-data/payment-method.json")
//@ConfigurationProperties
public class PaymentMethod {

	public String name;
	public String type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
