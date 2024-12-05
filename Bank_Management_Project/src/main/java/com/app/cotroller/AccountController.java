package com.app.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Account;
import com.app.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/{accountNo}")
	public Account getAccoutByAccountNo(@PathVariable Long accountNo) {
		Account account = service.getAccountDetailsByAccountNo(accountNo);
		return account;
	}
	@GetMapping("/getAll")
	public List<Account> getAllAccountDetails(){
		List<Account> allAccountDetails = service.getAllAccountDetails();
		return allAccountDetails;
	}
	@PutMapping("deposit/{accountNo}/{ammount}")
		public Account depositAccount(@PathVariable Long accountNo,@PathVariable Double ammount) {
		Account account = service.depositAmmount(accountNo, ammount);
		return account;
	}
	
	@PutMapping("withdraw/{accountNo}/{ammount}")
	public Account withdrawAccount(@PathVariable Long accountNo,@PathVariable Double ammount) {
	Account account = service.withdrawAmmount(accountNo, ammount);
	return account;
}
	@DeleteMapping("/delete/{accountNo}")
	public ResponseEntity deleteAccount(@PathVariable Long accountNo) {
		service.closeAccount(accountNo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
	}
}
