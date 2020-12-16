package com.kasun.dto;

public class Account {
	public Account() {}
	public Account(String cif, String accountNumber, String accountName, String accountType, long accountBalance) {
		super();
		this.cif = cif;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	private String cif;
	private String accountNumber;
	private String accountName;
	private String accountType;
	private long accountBalance;
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

}
