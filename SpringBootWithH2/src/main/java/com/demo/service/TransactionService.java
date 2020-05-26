package com.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Account;
import com.demo.entity.Transaction;
import com.demo.entity.TransactionStatus;
import com.demo.repo.AccountRepository;
import com.demo.repo.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactionRepository.findAll();
		return transactions;
	}

	public Transaction getTransactionById(int id) {
		return transactionRepository.findById(id).get();
	}

	public TransactionStatus getTransactionStatusById(int id) {
		return transactionRepository.findById(id).get().getStatus();
	}

	public void saveOrUpdate(Transaction transaction) {

		// Commission and deduction logic
		BigDecimal currentAmount = transaction.getAmount();

		Double d = currentAmount.doubleValue();

		double actualAmountA = d * 0.5 / 100;

		double actualAmountB = d * 0.2 / 100;

		transaction.setAmount(BigDecimal.valueOf(actualAmountA));
		transactionRepository.save(transaction);
		transaction.setStatus(TransactionStatus.SUCCESS);

		// update both the accounts

		Optional<Account> accountA = accountRepository.findById(transaction.getToAccountId().intValue());
		BigDecimal currentBalanceA = accountA.get().getBalance();

		accountA.get().setBalance(currentBalanceA.add(BigDecimal.valueOf(actualAmountA)));

		Optional<Account> accountB = accountRepository.findById(transaction.getFromAccountId().intValue());
		BigDecimal currentBalanceB = accountB.get().getBalance();

		accountB.get().setBalance(currentBalanceB.add(BigDecimal.valueOf(actualAmountB)));

		accountRepository.save(accountA.get());
		accountRepository.save(accountB.get());
	}

	public void delete(int id) {
		transactionRepository.deleteById(id);
	}

	public Transaction reverseTransactionById(int id) {

		// Get transaction details

		Transaction transactionDetails = transactionRepository.findById(id).get();

		// update both the accounts

		Optional<Account> toAccount = accountRepository.findById(transactionDetails.getToAccountId().intValue());
		Optional<Account> fromAccount = accountRepository.findById(transactionDetails.getFromAccountId().intValue());

		Double txnValueOfToAccount = toAccount.get().getBalance().doubleValue()
				- transactionDetails.getAmount().doubleValue();

		Double txnValueOfFromAccount = fromAccount.get().getBalance().doubleValue()
				+ transactionDetails.getAmount().doubleValue();

		toAccount.get().setBalance(BigDecimal.valueOf(txnValueOfToAccount));

		fromAccount.get().setBalance(BigDecimal.valueOf(txnValueOfFromAccount));

		accountRepository.save(toAccount.get());
		accountRepository.save(fromAccount.get());

		// update transaction status

		transactionDetails.setStatus(TransactionStatus.REVERTED);
		transactionRepository.save(transactionDetails);
		return transactionRepository.findById(transactionDetails.getId()).get();
	}

}
