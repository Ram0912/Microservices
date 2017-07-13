package com.doj.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteAccountRepository1 implements AccountRepository1 {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteAccountRepository1(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public List<Account> getAllAccountsService() {
		Account[] accounts = restTemplate.getForObject(serviceUrl + "/service/accounts", Account[].class);
		return Arrays.asList(accounts);
	}

	@Override
	public Account getAccountService(String number) {
		return restTemplate.getForObject(serviceUrl + "/service/accounts/{id}", Account.class, number);
	}
}
