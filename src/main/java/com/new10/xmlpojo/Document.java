package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Document")
public class Document {

	private BankToCustomerStatement bkToCstmrStmt;

	@XmlElement(name = "BkToCstmrStmt")
	public BankToCustomerStatement getBkToCstmrStmt() {
		return bkToCstmrStmt;
	}

	public void setBkToCstmrStmt(BankToCustomerStatement bkToCstmrStmt) {
		this.bkToCstmrStmt = bkToCstmrStmt;
	}
}
