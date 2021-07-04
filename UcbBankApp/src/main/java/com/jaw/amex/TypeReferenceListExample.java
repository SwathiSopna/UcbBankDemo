package com.jaw.amex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TypeReferenceListExample {

	public static void main(String a[]) throws JsonProcessingException {
		List<PendingResponse> pendingList = new ArrayList<>();
		PendingResponse pendingResponse= new PendingResponse();
		pendingResponse.setId("12");
		pendingResponse.setName("PAYMENT-DEVICE");
		Configuration configuration = new Configuration();
		configuration.setIssuesBundleId("12345");
		configuration.setDesignId("34567");
		pendingResponse.setConfiguration(configuration);
		
		PendingResponse pendingResponse1= new PendingResponse();
		pendingResponse1.setId("123");
		pendingResponse1.setName("PLAN_IT");
		Configuration configuration1 = new Configuration();
		configuration1.setIssuesBundleId("123456");
		configuration1.setDesignId("345677");
		pendingResponse1.setConfiguration(configuration1);
		pendingList.add(pendingResponse);
		pendingList.add(pendingResponse1);
		
		//System.out.println("ghdf"+pendingResponse);
		
		ObjectMapper obj = new ObjectMapper();
		obj.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		/*obj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		obj.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
		obj.registerSubtypes(PendingEnrollments.class);*/
		String jsonStr = obj.writeValueAsString(pendingList);
		//Feature list  = new Feature();
		List<Feature> list = new ArrayList<>();
		 list = obj.readValue(jsonStr, new TypeReference<List<Feature>>() {});
		 
		  /*  TypeReference<PendingEnrollments> mapType = new TypeReference<PendingEnrollments>() {};
		    PendingEnrollments towns = obj.readValue(jsonStr, mapType);*/
		    //System.out.println(list.size());
		
		/*Optional<Feature> pending = list.stream().filter(e->Objects.nonNull(e.getName()))
				.filter(e->e.getName().equalsIgnoreCase("Payment-Device"))
				.findFirst();
		*/
		 
		//System.out.println(list.getConfiguration());
		
	}
}
