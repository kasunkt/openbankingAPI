package com.kasun.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasun.dto.Account;
import com.kasun.dto.FundTransferRequest;
import com.kasun.dto.Trxn;
import com.kasun.dto.TrxnInqReq;
import com.kasun.dto.TrxnListResponse;
import com.kasun.repository.AccountRepo;
import com.kasun.repository.TokenRepo;
import com.kasun.repository.TrxnRepo;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TrxnRepo trxnRepo;

	@Autowired
	AccountRepo accRepo;
	
	@Autowired
	TokenRepo  tokenRepo;
	
	@PostMapping("/fundTransfer")
	public Trxn fundTransfer(FundTransferRequest transferReq ,@RequestHeader(name ="Authorization",   required=false)  String token) {
		System.out.println("inside fundTransfer");
		System.out.println("transferReq" +transferReq);
		tokenRepo.validateToken(token);
		boolean debitSuccess=false;
		boolean creditSuccess=false;
		Trxn trxn=new Trxn();

		trxn.setTrxnNo(UUID.randomUUID().toString());
		trxn.setTrxnType("fundTransfer");
		trxn.setAmount(transferReq.getAmount());
		trxn.setBenificiryAccount(transferReq.getBenificiryAccount());
		trxn.setBenificiryBank(transferReq.getBenificiryBank());
		trxn.setBenificiryName(transferReq.getBenificiryName());
		trxn.setCurrencyCode(transferReq.getCurrencyCode());
		trxn.setFromAccount(transferReq.getFromAccount());
		trxn.setStatus("SUCCESS");
		trxn.setError(null);
		trxn.setTrxnTime(new Timestamp(System.currentTimeMillis()).toString());
		trxn.setChannel(tokenRepo.getChannel(token));
		trxn.setPayeeName(transferReq.getPayeeName());
		
		
		String benCif =accRepo.getAccCifMap().get(trxn.getBenificiryAccount());
		String payeeCif =accRepo.getAccCifMap().get(trxn.getFromAccount());
		
		List<Account> benAccList =accRepo.getAccMap().get(benCif);
		
		List<Account> payeeAccList =accRepo.getAccMap().get(payeeCif);
		if(payeeAccList!=null) 
		{
			for (Account acc:payeeAccList ) 
			{
				if (acc.getAccountNumber().equals(trxn.getFromAccount()))
				{
					System.out.println("prev bal "+acc.getAccountBalance());
					acc.setAccountBalance(acc.getAccountBalance()-Long.parseLong(trxn.getAmount()));
					System.out.println("acc.getAccountNumber() "+acc.getAccountNumber());
					System.out.println("Ammount deducted "+trxn.getAmount());
					System.out.println("new bal "+acc.getAccountBalance());
					debitSuccess=true;
					break;
				}
			}
		}else 
		{
			trxn.setStatus("FAIL");
			trxn.setError("Payee Account not found.");
		}
		
		if(debitSuccess) 
		{
			if(benAccList!=null) 
			{
				for (Account acc:benAccList ) 
				{
					if (acc.getAccountNumber().equals(trxn.getBenificiryAccount()))
					{
						System.out.println("prev bal "+acc.getAccountBalance());
						acc.setAccountBalance(acc.getAccountBalance()+Long.parseLong(trxn.getAmount()));
						System.out.println("acc.getAccountNumber() "+acc.getAccountNumber());
						System.out.println("Ammount added "+trxn.getAmount());
						System.out.println("new bal "+acc.getAccountBalance());
						creditSuccess=true;
						break;
					}
				}
			}else 
			{
				trxn.setStatus("FAIL");
				trxn.setError("Benificiary Account not found.");
			}
		}
		
		if(creditSuccess && debitSuccess ) 
		{
			trxnRepo.getTrxnList().add(trxn);	
		}else 
		{
			trxn.setStatus("FAIL");
			trxn.setError(" Account Debit fail.");
		}
		return trxn;
	}
	
	@PostMapping("/list")
	public TrxnListResponse  listTrxns(TrxnInqReq req ,@RequestHeader(name ="Authorization",   required=false)  String token) {
		System.out.println("inside listTrxns");
		TrxnListResponse res = new TrxnListResponse();
 
		tokenRepo.validateToken(token);
		List<Trxn> benificaryTrxns =trxnRepo.getTrxnList().stream()
			.filter(trxn -> trxn.getBenificiryAccount().equals(req.getBenificiryAccount()))
			.collect(Collectors.toList());
		
		List<Trxn> payeeTrxns =trxnRepo.getTrxnList().stream()
				.filter(trxn -> trxn.getFromAccount().equals(req.getFromAccount()))
				.collect(Collectors.toList());
		
		
		res.setBenificaryTrxns(benificaryTrxns);
		res.setPayeeTrxns(payeeTrxns);
		res.setStatus("SUCCESS");
		res.setError(null);
		
		return res;
	}
}
