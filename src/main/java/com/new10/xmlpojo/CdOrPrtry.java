package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CdOrPrtry{

	@JsonProperty("Cd")
	private String cd;

	public void setCd(String cd){
		this.cd = cd;
	}

	public String getCd(){
		return cd;
	}
}