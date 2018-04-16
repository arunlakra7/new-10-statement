package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TtlDbtNtries {

	@JsonProperty("Sum")
	private String sum;

	@JsonProperty("NbOfNtries")
	private String nbOfNtries;

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getNbOfNtries() {
		return nbOfNtries;
	}

	public void setNbOfNtries(String nbOfNtries) {
		this.nbOfNtries = nbOfNtries;
	}
}