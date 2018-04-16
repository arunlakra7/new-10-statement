package com.new10.xmlpojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Stmt")
public class Stmt {

	private String creDtTm;

	private FrToDt frToDt;

	private List<NtryItem> ntry;

	private String id;

	private List<BalItem> bal;

	private Stmt() {
	}

	private Stmt(final Builder builder) {
		setCreDtTm(builder.creDtTm);
		setFrToDt(builder.frToDt);
		setNtry(builder.ntry);
		setId(builder.id);
		setBal(builder.bal);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@XmlElement(name = "CreDtTm")
	public String getCreDtTm() {
		return creDtTm;
	}

	public void setCreDtTm(String creDtTm) {
		this.creDtTm = creDtTm;
	}

	@XmlElement(name = "FrToDt")
	public FrToDt getFrToDt() {
		return frToDt;
	}

	public void setFrToDt(FrToDt frToDt) {
		this.frToDt = frToDt;
	}

	@XmlElement(name = "Ntry")
	public List<NtryItem> getNtry() {
		return ntry;
	}

	public void setNtry(List<NtryItem> ntry) {
		this.ntry = ntry;
	}

	@XmlElement(name = "Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "Bal")
	public List<BalItem> getBal() {
		return bal;
	}

	public void setBal(List<BalItem> bal) {
		this.bal = bal;
	}

	public static final class Builder {
		private String creDtTm;
		private FrToDt frToDt;
		private List<NtryItem> ntry;
		private String id;
		private List<BalItem> bal;

		private Builder() {
		}

		public Builder withCreDtTm(final String val) {
			creDtTm = val;
			return this;
		}

		public Builder withFrToDt(final FrToDt val) {
			frToDt = val;
			return this;
		}

		public Builder withNtry(final List<NtryItem> val) {
			ntry = val;
			return this;
		}

		public Builder withId(final String val) {
			id = val;
			return this;
		}

		public Builder withBal(final List<BalItem> val) {
			bal = val;
			return this;
		}

		public Stmt build() {
			return new Stmt(this);
		}
	}
}