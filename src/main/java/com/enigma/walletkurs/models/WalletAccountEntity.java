package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet_account")
public class WalletAccountEntity {

	
	@Id
	@Column(name="wallet_account_id")
	String walletAccount;
	
	@Column(name="wallet_id")
	String walletId;
	
	@Column(name="account_number")
	String accountNumber;
}
