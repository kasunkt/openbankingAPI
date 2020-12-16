package com.kasun.dto;

public class FundTransferResponse {
	private String fromAccount;
	private String benificiryBank;
	private String benificiryAccount;
	private String benificiryName;
	private String amount;
	private String currencyCode;
	private String trxnTime;
	private String status;
	private String error;
	
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getBenificiryBank() {
		return benificiryBank;
	}
	public void setBenificiryBank(String benificiryBank) {
		this.benificiryBank = benificiryBank;
	}
	public String getBenificiryAccount() {
		return benificiryAccount;
	}
	public void setBenificiryAccount(String benificiryAccount) {
		this.benificiryAccount = benificiryAccount;
	}
	public String getBenificiryName() {
		return benificiryName;
	}
	public void setBenificiryName(String benificiryName) {
		this.benificiryName = benificiryName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getTrxnTime() {
		return trxnTime;
	}
	public void setTrxnTime(String trxnTime) {
		this.trxnTime = trxnTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}


}
