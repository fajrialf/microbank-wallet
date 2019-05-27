package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction_type")
public class TransactionTypeEntity {

	@Id
	@Column(name="transaction_type_id")
	String transactionType;
	
	@Column(name="description")
	String description;
	
}
