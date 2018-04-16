package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TtlNtries")
public class TtlNtries {

	private String sum;

	private String nbOfNtries;

	@XmlElement(name = "Sum")
	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	@XmlElement(name = "NbOfNtries")
	public String getNbOfNtries() {
		return nbOfNtries;
	}

	public void setNbOfNtries(String nbOfNtries) {
		this.nbOfNtries = nbOfNtries;
	}
}