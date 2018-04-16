package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dt")
public class Dt {

	private String dt;

	private Dt() {
	}

	private Dt(final Builder builder) {
		setDt(builder.dt);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@XmlElement(name = "Dt")
	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public static final class Builder {
		private String dt;

		private Builder() {
		}

		public Builder withDt(final String val) {
			dt = val;
			return this;
		}

		public Dt build() {
			return new Dt(this);
		}
	}
}