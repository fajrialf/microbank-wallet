package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet")
public class WalletEntity {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wallet_id")
	String walletId;
	
	@Column(name="description")
	String description;
	
	@Column(name="created_date")
	Date createdDate;
	
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
