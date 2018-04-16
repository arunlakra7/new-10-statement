package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ValDt")
public class ValDt {

	private String dt;

	@XmlElement(name = "Dt")
	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}
}