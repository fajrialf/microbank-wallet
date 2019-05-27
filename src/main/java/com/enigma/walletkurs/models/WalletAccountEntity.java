package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet_account")
public class WalletAccountEntity {

	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wallet_account_id")
	String walletAccount;
	
	@ManyToOne
	@JoinColumn(name="wallet_id")
	WalletEntity walletId;
	
	@ManyToOne
	@JoinColumn(name="account_number")
	AccountEntity accountNumber;

	public String getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(String walletAccount) {
		this.walletAccount = walletAccount;
	}

	public WalletEntity getWalletId() {
		return walletId;
	}

	public void setWalletId(WalletEntity walletId) {
		this.walletId = walletId;
	}

	public AccountEntity getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(AccountEntity accountNumber) {
		this.accountNumber = accountNumber;
	}

	
}
