/**
 * 
 */
package com.doj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountRepository1 accountRepository1;
	@Autowired
	AccountRepository1 account;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	@RequestMapping("/accountList")
	public String accountList(Model model) {
		//model.addAttribute("accounts", accountRepository.getAllAccounts());
		model.addAttribute("account",accountRepository1.getAllAccountsService() );
		return "accountList";
	}
	
	@RequestMapping("/accountDetails")
	public String accountDetails(@RequestParam("number") String id, Model model) {
		//model.addAttribute("account", accountRepository.getAccount(id));
		model.addAttribute("accounts", accountRepository1.getAccountService(id));
		return "accountDetails";
	}
}
