package com.app.service;

import java.util.List;

import com.app.entity.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public Account getAccountDetailsByAccountNo(Long accountNo);
	public List<Account> getAllAccountDetails();
	public Account depositAmmount(Long accountNo,Double ammount);
	public Account withdrawAmmount(Long accountNo,Double ammount);
	public void closeAccount(Long accountNo);
}
