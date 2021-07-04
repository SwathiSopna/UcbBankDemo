package com.jaw.amex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PendingEnrollments {
    //private String id;
	//private String name;
	private Configuration configuration;
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	/*public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}*/
	
	
}
