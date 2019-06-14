package com.enigma.walletkurs.models.dto;


import java.util.Date;

import com.enigma.walletkurs.models.CustomerEntity;

public class WalletDto {
	String walletId;
	
	String description;
	
	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public CustomerDto getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(CustomerDto customerNumber) {
		this.customerNumber = customerNumber;
	}
	String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	Date createdDate;
	
	CustomerDto customerNumber;
}
