package com.jaw.UcbBankApp.model;

import java.io.Serializable;

public class UnEntrollDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String eventName;
	private String date;
	
	public UnEntrollDto() {}

	
public UnEntrollDto(int id,String eventName,String date) {
	    this.id= id ;
		this.eventName = eventName;
		this.date = date;
	}

	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static UnEntrollDto toEntity(UnEntrollDto user) {
		
		 return new UnEntrollDto(user.id, user.getEventName(), user.getDate());
	}
	

}
