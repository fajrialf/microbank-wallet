package com.enigma.walletkurs.dao;

import java.util.List;

import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.WalletDto;

public interface WalletDao {
	List<WalletEntity>getAllWallet();
	WalletEntity createwallet(WalletDto wallet) throws ExistException;
	WalletEntity getwalletById(String walletid);
	WalletAccountEntity registeraccount(WalletAccountEntity walletacc);
	List<WalletEntity>getAllWalletByCustomer(String customerNumber);
	List<WalletAccountEntity>getAllWalletAccountByWallet(String walletId);
	String deletewallet(String walletid) throws EntityNotFoundException;
}
