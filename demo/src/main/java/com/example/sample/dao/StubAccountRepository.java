package com.example.sample.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.sample.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
public class StubAccountRepository implements AccountRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	private Map<String, Account> accountsByNumber = new HashMap<String, Account>();

	public StubAccountRepository() {
		Account account = new Account(1500l, "lion", "1254");
		accountsByNumber.put("1254", account);
		account = new Account(2500l, "Tiger", "2576");
		accountsByNumber.put("2576", account);
		account = new Account(3500l, "Cheeta", "6458");
		accountsByNumber.put("6458", account);
		Logger.getLogger(StubAccountRepository.class).info("Created StubAccountRepository");
	}

	public StubAccountRepository(String accountsServiceUrl) {
		this.serviceUrl = accountsServiceUrl.startsWith("http") ? accountsServiceUrl
				: "http://" + accountsServiceUrl;
	}

	@Override
	public List<Account> getAllAccounts() {
		return new ArrayList<Account>(accountsByNumber.values());
	}

	@Override
	public Account getAccount(String number) {
		return accountsByNumber.get(number);
	}
	@Override
	public List<Account> getAllAccountsService(){
		Account[] accounts = restTemplate.getForObject(serviceUrl+"/accounts", Account[].class);
		return Arrays.asList(accounts);
		
			}
	@Override
	public Account getAccountService(String number) {
		return restTemplate.getForObject(serviceUrl + "/accounts/{id}",
				Account.class, number);
}
}
