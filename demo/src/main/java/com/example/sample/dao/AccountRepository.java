/**
 * 
 */
package com.example.sample.dao;

import java.util.List;

import com.example.sample.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
public interface AccountRepository {
	
	List<Account> getAllAccounts();
	
	Account getAccount(String number);
	
	List<Account> getAllAccountsService();
	
	Account getAccountService(String number);
	
}
