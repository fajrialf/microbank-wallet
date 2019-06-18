package com.enigma.walletkurs.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction")
public class TransactionEntity {

	@Id
	@Column(name="transaction_id")
	String transactionId;
	
	@Column(name="account_number_credit")
	String accountNumberCredit;
	
	@Column(name="account_number_debit")
	String accountNumberDebit;
	
	@Column(name="amount")
	Double amount;
	
	@Column(name="date",updatable=false)
	Date date;
	
	@Column(name="description")
	String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne
	@JoinColumn(name="transaction_type_id")
	TransactionTypeEntity transactionType;

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

	public TransactionTypeEntity getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypeEntity transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
