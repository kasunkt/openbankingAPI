package com.kasun.dto;

import java.util.List;

public class TrxnListResponse {

	List<Trxn> benificaryTrxns;
	List<Trxn> payeeTrxns;
	private String status;
	private String error;
	
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
	
	public List<Trxn> getBenificaryTrxns() {
		return benificaryTrxns;
	}
	public void setBenificaryTrxns(List<Trxn> benificaryTrxns) {
		this.benificaryTrxns = benificaryTrxns;
	}
	public List<Trxn> getPayeeTrxns() {
		return payeeTrxns;
	}
	public void setPayeeTrxns(List<Trxn> payeeTrxns) {
		this.payeeTrxns = payeeTrxns;
	}

}
