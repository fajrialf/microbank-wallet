package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	String amount;
	
	@Column(name="date")
	Date date;
	
	@Column(name="transaction_type_id")
	String transactionType;
}
