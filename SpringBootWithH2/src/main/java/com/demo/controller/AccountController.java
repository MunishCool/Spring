package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Account;
import com.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("/accounts")
	private List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("account/{id}")
	private Account getAccount(@PathVariable("id") int id) {
		return accountService.getAccountById(id);
	}

	@DeleteMapping("/account/{id}")
	private void deleteAccount(@PathVariable("id") int id) {
		accountService.delete(id);
	}

	@PostMapping("/account")
	private int saveAccount(@RequestBody Account account) {
		accountService.saveOrUpdate(account);
		return account.getId();
	}

	@PutMapping("account/wallet/{id}/{amount}")
	private Account addMoneyToWallet(@PathVariable("id") int id, @PathVariable("amount") int amount) {
		return accountService.addMoneyToWallet(id, amount);
	}
}
