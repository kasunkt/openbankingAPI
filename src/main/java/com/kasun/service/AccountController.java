package com.kasun.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasun.dto.Account;
import com.kasun.dto.AccountCreRequest;
import com.kasun.dto.AccountListRequest;
import com.kasun.dto.AccountListResp;
import com.kasun.repository.AccountRepo;
import com.kasun.repository.TokenRepo;
 

@RestController
@RequestMapping("Account")
public class AccountController {
	
	@Autowired
	AccountRepo accRepo;

	@Autowired
	TokenRepo  tokenRepo;
	
	@PostMapping("/list")
	public AccountListResp  listAccounts(AccountListRequest accListReq
			,@RequestHeader(name ="Authorization",   required=false)  String token) 
	{
		System.out.println("inside Account list" +accListReq);
		
		tokenRepo.validateToken(token);
		AccountListResp res=new AccountListResp();
		res.setAccountList(accRepo.getAccMap().get(accListReq.getCif()));
		res.setError(null);
		res.setStatus("SUCCESS");
		return res;
	}

	
	@PostMapping("/create")
	public Account  createAccount(AccountCreRequest accCre ,@RequestHeader(name ="Authorization",   required=false)  String token) 
	{
		System.out.println("inside  createAccount");
		tokenRepo.validateToken(token);
		Account	acc=new Account(accCre.getCif(), UUID.randomUUID().toString(), accCre.getAccountName(), accCre.getAccountType(), 1000l);
	 
		List<Account> accList =accRepo.getAccMap().get(accCre.getCif()) ;
		
		if(accList==null || accList.size()==0) 
		{
			List<Account> newList=new ArrayList<Account>();
			newList.add(acc);
			accRepo.getAccMap().put(accCre.getCif(), newList);	
			
		}else 
		{
			accList.add(acc);
			accRepo.getAccMap().replace(accCre.getCif(), accList);	
		}
		accRepo.getAccCifMap().put(acc.getAccountNumber(), acc.getCif());
		
		return acc;
	}
}
