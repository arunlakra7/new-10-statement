package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Svcr{

	@JsonProperty("FinInstnId")
	private FinInstnId finInstnId;

	public void setFinInstnId(FinInstnId finInstnId){
		this.finInstnId = finInstnId;
	}

	public FinInstnId getFinInstnId(){
		return finInstnId;
	}
}