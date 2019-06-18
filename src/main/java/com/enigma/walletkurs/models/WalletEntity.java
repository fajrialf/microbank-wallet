package com.enigma.walletkurs.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet")
public class WalletEntity {

	@Id
	@Column(name="wallet_id")
	String walletId;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="description")
	String description;
	
	@Column(name="created_date")
	Date createdDate;

	@Column(name="status")
	String status;
	
	@ManyToOne
	@JoinColumn(name="customer_number")
	CustomerEntity customerNumber;

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

	public CustomerEntity getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(CustomerEntity customerNumber) {
		this.customerNumber = customerNumber;
	}
	
}
