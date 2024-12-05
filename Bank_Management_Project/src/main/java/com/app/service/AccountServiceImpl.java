package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Account;
import com.app.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository repo;
	
	@Override
	public Account createAccount(Account account) {
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNo(Long accountNo) {
		Optional<Account> account =repo.findById(accountNo);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account account_found=account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listOfAccounts= repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account depositAmmount(Long accountNo, Double ammount) {
		Optional<Account> account = repo.findById(accountNo);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent = account.get();
		Double totalBalance = accountPresent.getAccount_balance()+ammount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawAmmount(Long accountNo, Double ammount) {
		Optional<Account> account = repo.findById(accountNo);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent = account.get();
		Double accountBalance = accountPresent.getAccount_balance()-ammount;
		accountPresent.setAccount_balance(accountBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNo) {
		getAccountDetailsByAccountNo(accountNo);
		repo.deleteById(accountNo);
		
	}

}
