package com.new10.xmlpojo;

import com.new10.support.WithValueAsDouble;
import com.new10.util.DoubleUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Amt")
public class Amt implements WithValueAsDouble {

	private String value;

	private String ccy;

	private Amt() {
	}

	private Amt(final Builder builder) {
		setValue(builder.value);
		setCcy(builder.ccy);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@XmlValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlAttribute(name = "Ccy")
	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	@Override
	public Double getValueAsDouble() {
		return DoubleUtils.stringToDouble(value);
	}

	public static final class Builder {
		private String value;
		private String ccy;

		private Builder() {
		}

		public Builder withValue(final String val) {
			value = val;
			return this;
		}

		public Builder withCcy(final String val) {
			ccy = val;
			return this;
		}

		public Amt build() {
			return new Amt(this);
		}
	}
}