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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wallet_account_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name="wallet_id")
	WalletEntity walletId;
	
	@ManyToOne
	@JoinColumn(name="account_number")
	AccountEntity accountNumber;

	@Column(name="status")
	String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
