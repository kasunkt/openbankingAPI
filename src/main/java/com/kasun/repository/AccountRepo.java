package com.kasun.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kasun.dto.Account;

@Repository
public class AccountRepo {
	
	private Map<String,List<Account>> accMap= new HashMap<String,List<Account>>();
	private Map<String,String> accCifMap=new HashMap<>();
	
	public Map<String, String> getAccCifMap() {
		return accCifMap;
	}

	public void setAccCifMap(Map<String, String> accCifMap) {
		this.accCifMap = accCifMap;
	}

	public void setAccMap(Map<String, List<Account>> accMap) {
		this.accMap = accMap;
	}

	public Map<String, List<Account>> getAccMap() {
		return accMap;
	}

	AccountRepo()
	{
		/*List<Account> kasunAccounts=new ArrayList<>();
		
		kasunAccounts.add(new Account("100", "123456", "Kasun's primary Acc.", "Saving", 1000l));
		kasunAccounts.add(new Account("100", "123555", "Kasun's Personal Acc.", "Current", 500l));
		
		List<Account> lucifurAccounts=new ArrayList<>();
		
		lucifurAccounts.add(new Account("200", "555555", "Lucifur's business Acc.", "Saving", 9000l));
		lucifurAccounts.add(new Account("200", "555555", "Lucifur's Personal Acc.", "Current",7000l));
		
		accMap.put("100", kasunAccounts);
		accMap.put("200", lucifurAccounts);
		*/
	}
	
	

}
