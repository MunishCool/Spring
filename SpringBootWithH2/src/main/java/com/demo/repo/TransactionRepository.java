package com.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}