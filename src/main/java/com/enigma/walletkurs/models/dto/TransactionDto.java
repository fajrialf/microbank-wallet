package com.enigma.walletkurs.models.dto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class TransactionDto {

	String transactionId;
	
	String accountNumberCredit;
	
	String accountNumberDebit;
	
	Double amount;
	
	@Column(name="date")
	Date date;
	
	@OneToOne
	@JoinColumn(name="transaction_type_id")
	TransactionTypeDto transactionType;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumberCredit() {
		return accountNumberCredit;
	}

	public void setAccountNumberCredit(String accountNumberCredit) {
		this.accountNumberCredit = accountNumberCredit;
	}

	public String getAccountNumberDebit() {
		return accountNumberDebit;
	}

	public void setAccountNumberDebit(String accountNumberDebit) {
		this.accountNumberDebit = accountNumberDebit;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TransactionTypeDto getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypeDto transactionType) {
		this.transactionType = transactionType;
	}
	
}
