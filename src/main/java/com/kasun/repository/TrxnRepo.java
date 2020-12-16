package com.kasun.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasun.dto.Trxn;

@Repository
public class TrxnRepo {

	private  List<Trxn> trxnList= new ArrayList<>();

	public List<Trxn> getTrxnList() {
		return trxnList;
	}

	public void setTrxnList(List<Trxn> trxnList) {
		this.trxnList = trxnList;
	}
 
}
