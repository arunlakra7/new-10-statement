package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Acct")
public class Acct {

	private Svcr svcr;

	private String ccy;

	private Id id;

	private Tp tp;

	@XmlElement(name = "Svcr")
	public Svcr getSvcr() {
		return svcr;
	}

	public void setSvcr(Svcr svcr) {
		this.svcr = svcr;
	}

	@XmlElement(name = "Ccy")
	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	@XmlElement(name = "Id")
	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	@XmlElement(name = "Tp")
	public Tp getTp() {
		return tp;
	}

	public void setTp(Tp tp) {
		this.tp = tp;
	}
}