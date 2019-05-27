package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	String transactionId;
	
	@Column(name="account_number_credit")
	String accountNumberCredit;
	
	@Column(name="account_number_debit")
	String accountNumberDebit;
	
	@Column(name="amount")
	Float amount;
	
	@Column(name="date")
	Date date;
	
	@OneToOne
	@JoinColumn(name="transaction_type_id")
	String transactionType;

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

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
}
