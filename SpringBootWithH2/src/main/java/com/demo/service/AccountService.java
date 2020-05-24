package com.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Account;
import com.demo.entity.AccountStatus;
import com.demo.repo.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		accountRepository.findAll();
		return accounts;
	}

	public Account getAccountById(int id) {
		return accountRepository.findById(id).get();
	}

	public AccountStatus getAccountStatusById(int id) {
		return accountRepository.findById(id).get().getAccountStatus();
	}

	public void saveOrUpdate(Account account) {

		accountRepository.save(account);

	}

	public void delete(int id) {
		accountRepository.deleteById(id);
	}

	public Account addMoneyToWallet(int id, int amount) {
		Account accountDetails = accountRepository.findById(id).get();
		BigDecimal currentBalance = accountDetails.getBalance();
		BigDecimal updatedBalance = currentBalance.add(BigDecimal.valueOf(amount));
		accountDetails.setBalance(updatedBalance);
		accountDetails.setAccountStatus(AccountStatus.WALLET);
		accountRepository.save(accountDetails);
		return accountRepository.findById(id).get();
	}
}
