package com.enigma.walletkurs.models.dto;

public class WalletAccountDto {

	
	int id;
	
	WalletDto walletId;
	
	AccountDto accountNumber;

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

	public WalletDto getWalletId() {
		return walletId;
	}

	public void setWalletId(WalletDto walletId) {
		this.walletId = walletId;
	}

	public AccountDto getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(AccountDto accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
