package com.kasun.dto;

public class TrxnInqReq {

	private String trxnNo;
	private String trxnType;
	private String cif;

	private String fromAccount;
	private String benificiryAccount;

	private String currencyCode;
	
	public String getTrxnNo() {
		return trxnNo;
	}
	public void setTrxnNo(String trxnNo) {
		this.trxnNo = trxnNo;
	}
	public String getTrxnType() {
		return trxnType;
	}
	public void setTrxnType(String trxnType) {
		this.trxnType = trxnType;
	}
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
 
	public String getBenificiryAccount() {
		return benificiryAccount;
	}
	public void setBenificiryAccount(String benificiryAccount) {
		this.benificiryAccount = benificiryAccount;
	}
 
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	

}
