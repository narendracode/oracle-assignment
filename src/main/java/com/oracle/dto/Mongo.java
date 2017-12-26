package com.oracle.dto;

import org.springframework.data.annotation.Id;

public class Mongo {
	
	@Id
	public String id;
	public String key;
	public String value;
	public String keyValue;
	

	public Mongo() {
		super();
	}
	public Mongo(String key, String value) {
		this();
		this.id = java.util.UUID.randomUUID().toString();
		this.key = key;
		this.value = value;
	}
	
	public Mongo(String key, String value,String keyValue) {
		this(key,value);
		this.keyValue = keyValue;
	}
	
	public Mongo(String id, String key, String value, String keyValue) {
		this(key,value);
		this.keyValue = keyValue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	
	
}
