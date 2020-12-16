package com.kasun.dto;

public class FundTransferRequest {

	@Override
	public String toString() {
		return "FundTransferRequest [cif=" + cif + ", fromAccount=" + fromAccount + ", benificiryBank=" + benificiryBank
				+ ", benificiryAccount=" + benificiryAccount + ", benificiryName=" + benificiryName + ", amount="
				+ amount + ", currencyCode=" + currencyCode + ", payeeName=" + payeeName + "]";
	}

	private String cif;
	private String fromAccount;
	private String benificiryBank;
	private String benificiryAccount;
	private String benificiryName;
	private String amount;
	private String currencyCode;
	private String payeeName;

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
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

}
