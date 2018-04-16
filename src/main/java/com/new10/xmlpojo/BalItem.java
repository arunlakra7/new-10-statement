package com.new10.xmlpojo;

import com.new10.pojo.YearMonthDay;
import com.new10.support.yearmonthday.WithYearMonthDay;
import com.new10.util.LocalDateUtils;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BalItem")
public class BalItem implements WithYearMonthDay {

	private Dt dt;

	private Amt amt;

	private String cdtDbtInd;

	private Tp tp;

	private BalItem() {
	}

	private BalItem(final Builder builder) {
		setDt(builder.dt);
		setAmt(builder.amt);
		setCdtDbtInd(builder.cdtDbtInd);
		setTp(builder.tp);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@XmlElement(name = "Dt")
	public Dt getDt() {
		return dt;
	}

	public void setDt(Dt dt) {
		this.dt = dt;
	}

	@XmlElement(name = "Amt")
	public Amt getAmt() {
		return amt;
	}

	public void setAmt(Amt amt) {
		this.amt = amt;
	}

	@XmlElement(name = "CdtDbtInd")
	public String getCdtDbtInd() {
		return cdtDbtInd;
	}

	public void setCdtDbtInd(String cdtDbtInd) {
		this.cdtDbtInd = cdtDbtInd;
	}

	@XmlElement(name = "Tp")
	public Tp getTp() {
		return tp;
	}

	public void setTp(Tp tp) {
		this.tp = tp;
	}

	@Override
	public YearMonthDay getYearMonthDay() {
		final LocalDate localDate = LocalDateUtils.stringToLocalDate(dt.getDt());
		return YearMonthDay.builder().year(localDate.getYear()).month(localDate.getMonthValue()).day(localDate.getDayOfMonth()).build();
	}

	public static final class Builder {
		private Dt dt;
		private Amt amt;
		private String cdtDbtInd;
		private Tp tp;

		private Builder() {
		}

		public Builder withDt(final Dt val) {
			dt = val;
			return this;
		}

		public Builder withAmt(final Amt val) {
			amt = val;
			return this;
		}

		public Builder withCdtDbtInd(final String val) {
			cdtDbtInd = val;
			return this;
		}

		public Builder withTp(final Tp val) {
			tp = val;
			return this;
		}

		public BalItem build() {
			return new BalItem(this);
		}
	}
}