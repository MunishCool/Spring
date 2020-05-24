package com.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {


}