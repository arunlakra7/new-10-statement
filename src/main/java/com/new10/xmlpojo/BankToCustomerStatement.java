package com.new10.xmlpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BkToCstmrStmt")
public class BankToCustomerStatement {

	private Stmt stmt;

	@XmlElement(name = "Stmt")
	public Stmt getStmt() {
		return stmt;
	}

	public void setStmt(Stmt stmt) {
		this.stmt = stmt;
	}
}