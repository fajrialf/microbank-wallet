package com.enigma.walletkurs.models.dto;

public class TransactionTypeDto {

	String code;
	
	String description;

	public String getTransactionType() {
		return code;
	}

	public void setTransactionType(String transactionType) {
		this.code = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
