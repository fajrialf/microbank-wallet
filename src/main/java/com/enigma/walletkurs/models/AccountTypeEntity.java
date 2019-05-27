package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account_type")
public class AccountTypeEntity {

	@Id
	@Column(name="account_type_id")
	Integer accountType;
	
	@Column(name="code")
	String code;
	
	@Column(name="description")
	String description;
}
