package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet")
public class WalletEntity {

	@Id
	@Column(name="wallet_id")
	String walletId;
	
	@Column(name="description")
	String description;
	
	@Column(name="created_date")
	Date createdDate;
	
	@OneToMany
	@Column(name="customer_number")
	String customerNumber;

	
}
