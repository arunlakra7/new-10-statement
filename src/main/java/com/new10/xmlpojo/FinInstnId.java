package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class FinInstnId{

	@JsonProperty("BIC")
	private String bIC;

	public void setBIC(String bIC){
		this.bIC = bIC;
	}

	public String getBIC(){
		return bIC;
	}
}