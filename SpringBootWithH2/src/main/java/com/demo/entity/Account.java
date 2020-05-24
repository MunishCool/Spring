package com.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private int id; // accountId

	private AccountType accountType;

	private String customerName;

	private String customerEmail;

	private String customerAddress;

	private String customerMobile;

	private String customerIdProof;

	private String customerPassword;

	private BigDecimal balance;

	private AccountStatus accountStatus;

	public Account() {
	}

	public Account(String customerName, String customerEmail, String customerAddress, String customerMobile,
			String customerIdProof, String customerPassword, BigDecimal balance) {
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerMobile = customerMobile;
		this.customerIdProof = customerIdProof;
		this.customerPassword = customerPassword;
		this.balance = balance;
	}

	public Account(int id, String customerName, String customerEmail, String customerAddress, String customerMobile,
			String customerIdProof, String customerPassword, BigDecimal balance, AccountType accountType,
			AccountStatus accountStatus) {
		this.id = id;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerMobile = customerMobile;
		this.customerIdProof = customerIdProof;
		this.customerPassword = customerPassword;
		this.balance = balance;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}

	public String getcustomerEmail() {
		return customerEmail;
	}

	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getcustomerAddress() {
		return customerAddress;
	}

	public void setcustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getcustomerName() {
		return customerName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerIdProof() {
		return customerIdProof;
	}

	public void setCustomerIdProof(String customerIdProof) {
		this.customerIdProof = customerIdProof;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Account account = (Account) o;

		if (id != account.id)
			return false;
		if (!customerName.equals(account.customerName))
			return false;
		if (!customerEmail.equals(account.customerEmail))
			return false;
		if (!customerAddress.equals(account.customerAddress))
			return false;
		if (!balance.equals(account.balance))
			return false;
		return false;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + customerName.hashCode();
		result = 31 * result + customerEmail.hashCode();
		result = 31 * result + customerAddress.hashCode();
		result = 31 * result + balance.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Account{" + "accountId=" + id + ", " + "accountType='" + accountType + '\'' + ", " + "customerName='"
				+ customerName + '\'' + ", " + "balance=" + balance + ", " + "customerEmail=" + customerEmail + ","
				+ "customerMobile=" + customerMobile + "," + "customerIdProof=" + customerIdProof + "," + " "
				+ "customerAddress=" + customerAddress + '\'' + '}';
	}
}
