package com.jaw.UcbBankApp.actuatorEndPoint;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserAppInfo {

	private Map<String,Object> healthDetails = new LinkedHashMap<>();

	public Map<String, Object> getHealthDetails() {
		return healthDetails;
	}

	public void setHealthDetails(Map<String, Object> healthDetails) {
		this.healthDetails = healthDetails;
	}
	
	
}
