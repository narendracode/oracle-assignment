package com.oracle.dto;

public class TResponse {
	private String status;
	private String message;
	private Mongo mongo;
	
	
	
	public TResponse() {
		super();
	}
	
	public TResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public TResponse(String status, String message, Mongo mongo) {
		super();
		this.status = status;
		this.message = message;
		this.mongo = mongo;
	}



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Mongo getMongo() {
		return mongo;
	}
	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}
	
	
	
	
}
