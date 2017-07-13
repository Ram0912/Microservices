/**
 * 
 */
package com.example.sample.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.dao.AccountRepository;
import com.example.sample.model.Account;

@RestController

public class AccountController {

	protected Logger logger = Logger.getLogger(AccountController.class.getName());

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/accounts")
	public Account[] all() {
		logger.info("accounts-microservice all() invoked");
		List<Account> accounts = accountRepository.getAllAccounts();
		logger.info("accounts-microservice all() found: " + accounts.size());
		return accounts.toArray(new Account[accounts.size()]);
	}

	@GetMapping("/accounts/{id}")
	public Account byId(@PathVariable("id") String id) {
		logger.info("accounts-microservice byId() invoked: " + id);
		Account account = accountRepository.getAccount(id);
		logger.info("accounts-microservice byId() found: " + account);
		return account;
	}

	@GetMapping("/service/accounts")
	public Account[] alll() {

		List<Account> accounts = accountRepository.getAllAccountsService();

		return accounts.toArray(new Account[accounts.size()]);
	}

	@GetMapping("/service/accounts/{id}")
	public Account byIdS(@PathVariable("id") String id) {

		Account account = accountRepository.getAccountService(id);

		return account;
	}
}
