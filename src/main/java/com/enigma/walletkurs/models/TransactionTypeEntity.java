package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction_type")
public class TransactionTypeEntity {

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_type_id")
	String transactionType;
	
	@Column(name="description")
	String description;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
