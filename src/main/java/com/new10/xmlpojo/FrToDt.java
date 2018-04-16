package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FrToDt")
public class FrToDt {

	private String toDtTm;

	private String frDtTm;

	private FrToDt() {
	}

	private FrToDt(final Builder builder) {
		setToDtTm(builder.toDtTm);
		setFrDtTm(builder.frDtTm);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@XmlElement(name = "ToDtTm")
	public String getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(String toDtTm) {
		this.toDtTm = toDtTm;
	}

	@XmlElement(name = "FrDtTm")
	public String getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(String frDtTm) {
		this.frDtTm = frDtTm;
	}

	public static final class Builder {
		private String toDtTm;
		private String frDtTm;

		private Builder() {
		}

		public Builder withToDtTm(final String val) {
			toDtTm = val;
			return this;
		}

		public Builder withFrDtTm(final String val) {
			frDtTm = val;
			return this;
		}

		public FrToDt build() {
			return new FrToDt(this);
		}
	}
}