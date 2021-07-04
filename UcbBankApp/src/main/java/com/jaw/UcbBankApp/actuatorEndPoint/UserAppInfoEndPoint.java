package com.jaw.UcbBankApp.actuatorEndPoint;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
//@Endpoint(id="UserAppInfo")
public class UserAppInfoEndPoint {

	@ReadOperation
	public UserAppInfo userAppInfo() {
		Map<String,Object> details = new LinkedHashMap<>();
		details.put("App Location", "Mars!!");
		details.put("Status", "Reporting From Mars!!");
		UserAppInfo health = new UserAppInfo();
		health.setHealthDetails(details);
		return health;
		
	}

}
