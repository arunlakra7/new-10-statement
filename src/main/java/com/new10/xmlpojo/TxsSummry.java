package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TxsSummry")
public class TxsSummry {

	private TtlNtries ttlNtries;

	private TtlCdtNtries ttlCdtNtries;

	private TtlDbtNtries ttlDbtNtries;

	@XmlElement(name = "TtlNtries")
	public TtlNtries getTtlNtries() {
		return ttlNtries;
	}

	public void setTtlNtries(TtlNtries ttlNtries) {
		this.ttlNtries = ttlNtries;
	}

	@XmlElement(name = "TtlCdtNtries")
	public TtlCdtNtries getTtlCdtNtries() {
		return ttlCdtNtries;
	}

	public void setTtlCdtNtries(TtlCdtNtries ttlCdtNtries) {
		this.ttlCdtNtries = ttlCdtNtries;
	}

	@XmlElement(name = "TtlDbtNtries")
	public TtlDbtNtries getTtlDbtNtries() {
		return ttlDbtNtries;
	}

	public void setTtlDbtNtries(TtlDbtNtries ttlDbtNtries) {
		this.ttlDbtNtries = ttlDbtNtries;
	}
}