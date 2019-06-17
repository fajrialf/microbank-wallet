package com.enigma.walletkurs.dao;

import java.util.List;

import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.dto.AccountDto;

public interface AccountDao {
	List<AccountEntity> getAccountsByCustomerNumber(String string)  ;
	AccountEntity getByAccountNumber(String accountNumber);
	AccountEntity getByDescription(String accountNumber,String desc);
	AccountEntity create(AccountDto account) throws ExistException;
	AccountEntity update(AccountDto account);
	AccountEntity delete(AccountEntity account);
	Double getBalance(String accountNumber);
	AccountEntity updateBalance(String accountNumber, Double result);
}
