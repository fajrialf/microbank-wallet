package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet_account")
public class WalletAccountEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wallet_account_id")
	String walletAccount;
	
	@OneToMany
	@JoinColumn(name="wallet_id")
	String walletId;
	
	@OneToMany
	@JoinColumn(name="account_number")
	String accountNumber;

	public String getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(String walletAccount) {
		this.walletAccount = walletAccount;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
