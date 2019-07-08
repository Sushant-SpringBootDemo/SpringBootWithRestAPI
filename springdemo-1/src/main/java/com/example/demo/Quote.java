package com.example.demo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

	/*private String type;*/
	private Value value[];

	public Quote() {
	}

	public Value[] getValue() {
		return value;
	}

	public void setValue(Value[] value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Quote [value=" + Arrays.toString(value) + "]";
	}

	/*public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}*/

	

	

}
