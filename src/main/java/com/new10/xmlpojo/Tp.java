package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Tp{

	@JsonProperty("CdOrPrtry")
	private CdOrPrtry cdOrPrtry;

	public void setCdOrPrtry(CdOrPrtry cdOrPrtry){
		this.cdOrPrtry = cdOrPrtry;
	}

	public CdOrPrtry getCdOrPrtry(){
		return cdOrPrtry;
	}
}