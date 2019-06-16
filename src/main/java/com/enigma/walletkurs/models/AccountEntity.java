
package com.enigma.walletkurs.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_account")
public class AccountEntity {

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "account_number")
	String accountNumber;

	@Column(name = "account_name")
	String accountName;

	@ManyToOne
	@JoinColumn(name = "code")
	AccountTypeEntity accountType;

	@Column(name = "balance")
	Double balance;

	@Column(name = "open_date")
	Date openDate;

	@ManyToOne
	@JoinColumn(name = "customer_number")
	CustomerEntity customerNumber;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
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

	public AccountTypeEntity getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEntity accountType) {
		this.accountType = accountType;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public CustomerEntity getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(CustomerEntity customerNumber) {
		this.customerNumber = customerNumber;
	}

}
