package com.new10.xmlpojo;

import com.new10.pojo.YearMonthDay;
import com.new10.support.yearmonthday.WithYearMonthDay;
import com.new10.util.LocalDateUtils;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Ntry")
public class NtryItem implements WithYearMonthDay {

	private String ntryRef;

	private String sts;

	private ValDt valDt;

	private Amt amt;

	private String cdtDbtInd;

	private BookgDt bookgDt;

	private String acctSvcrRef;

	private NtryItem() {
	}

	private NtryItem(final Builder builder) {
		setNtryRef(builder.ntryRef);
		setSts(builder.sts);
		setValDt(builder.valDt);
		setAmt(builder.amt);
		setCdtDbtInd(builder.cdtDbtInd);
		setBookgDt(builder.bookgDt);
		setAcctSvcrRef(builder.acctSvcrRef);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@XmlElement(name = "NtryRef")
	public String getNtryRef() {
		return ntryRef;
	}

	public void setNtryRef(String ntryRef) {
		this.ntryRef = ntryRef;
	}

	@XmlElement(name = "Sts")
	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	@XmlElement(name = "ValDt")
	public ValDt getValDt() {
		return valDt;
	}

	public void setValDt(ValDt valDt) {
		this.valDt = valDt;
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

	@XmlElement(name = "BookgDt")
	public BookgDt getBookgDt() {
		return bookgDt;
	}

	public void setBookgDt(BookgDt bookgDt) {
		this.bookgDt = bookgDt;
	}

	@XmlElement(name = "AcctSvcrRef")
	public String getAcctSvcrRef() {
		return acctSvcrRef;
	}

	public void setAcctSvcrRef(String acctSvcrRef) {
		this.acctSvcrRef = acctSvcrRef;
	}

	@Override
	public YearMonthDay getYearMonthDay() {
		final LocalDate localDate = LocalDateUtils.stringToLocalDate(valDt.getDt());
		return YearMonthDay.builder().year(localDate.getYear()).month(localDate.getMonthValue()).day(localDate.getDayOfMonth()).build();
	}

	public static final class Builder {
		private String ntryRef;
		private String sts;
		private ValDt valDt;
		private Amt amt;
		private String cdtDbtInd;
		private BookgDt bookgDt;
		private String acctSvcrRef;

		private Builder() {
		}

		public Builder withNtryRef(final String val) {
			ntryRef = val;
			return this;
		}

		public Builder withSts(final String val) {
			sts = val;
			return this;
		}

		public Builder withValDt(final ValDt val) {
			valDt = val;
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

		public Builder withBookgDt(final BookgDt val) {
			bookgDt = val;
			return this;
		}

		public Builder withAcctSvcrRef(final String val) {
			acctSvcrRef = val;
			return this;
		}

		public NtryItem build() {
			return new NtryItem(this);
		}
	}
}