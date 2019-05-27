package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_account")
public class AccountEntity {

	@Id
	@Column(name = "account_number")
	String accountNumber;

	@Column(name = "account_name")
	String accountName;

	@OneToOne
	@Column(name = "account_type_id")
	Integer accountType;

	@Column(name = "balance")
	Double balance;

	@Column(name = "open_date")
	Date openDate;

	@OneToMany
	@Column(name = "customer_number")
	String customerNumber;


}
