package com.jaw.amex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name", visible = true, defaultImpl = PendingEnrollments.class)
@JsonSubTypes ( {
	@JsonSubTypes.Type(value = PendingEnrollments.class, name = "PAYMENT-DEVICE")
})
public class Feature {
	
@JsonProperty( "name")
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}




}
