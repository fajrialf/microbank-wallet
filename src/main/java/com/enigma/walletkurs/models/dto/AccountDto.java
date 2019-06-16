package com.enigma.walletkurs.models.dto;

import java.sql.Date;

public class AccountDto {

	String accountNumber;

	String accountName;

	AccountTypeDto accountType;

	Double balance;

	Date openDate;

	CustomerDto customerNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public AccountTypeDto getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeDto accountType) {
		this.accountType = accountType;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public CustomerDto getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(CustomerDto customerNumber) {
		this.customerNumber = customerNumber;
	}

}
