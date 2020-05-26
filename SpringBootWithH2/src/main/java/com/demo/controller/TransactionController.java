package com.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Transaction;
import com.demo.entity.TransactionStatus;
import com.demo.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping("/transactions")
	private List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}

	@GetMapping("/transactions/{id}")
	private List<Transaction> getAllTransactionsByUserId(@PathVariable("id") int id) {
		List<Transaction> userTransactions = ((Collection<Transaction>) transactionService.getAllTransactions()).stream().filter(t -> {
			return t.getToAccountId().equals(Long.valueOf(id));
		}).collect(Collectors.toList());

		return userTransactions;

	}

	@GetMapping("transaction/{id}")
	private Transaction getTransaction(@PathVariable("id") int id) {
		return transactionService.getTransactionById(id);
	}

	@GetMapping("transaction/status/{id}")
	private TransactionStatus getTransactionStatus(@PathVariable("id") int id) {
		return transactionService.getTransactionStatusById(id);
	}

	@DeleteMapping("/transaction/{id}")
	private void deleteTransaction(@PathVariable("id") int id) {
		transactionService.delete(id);
	}

	@PutMapping("transaction/reverese/{id}")
	private Transaction revereseTransaction(@PathVariable("id") int id) {
		return transactionService.reverseTransactionById(id);
	}

	@PostMapping("/transaction")
	private int saveTransaction(@RequestBody Transaction transaction) {
		transactionService.saveOrUpdate(transaction);
		return transaction.getId();
	}
}
