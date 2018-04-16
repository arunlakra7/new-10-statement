package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Id{

	@JsonProperty("IBAN")
	private String iBAN;

	public void setIBAN(String iBAN){
		this.iBAN = iBAN;
	}

	public String getIBAN(){
		return iBAN;
	}
}