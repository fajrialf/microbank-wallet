package com.enigma.walletkurs.dao;

import java.util.List;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.AccountDto;

public interface AccountDao {
	List<AccountEntity> getAccountsByCustomerNumber(String string)  ;
	AccountEntity getByAccountNumber(String accountNumber);
	AccountEntity create(AccountDto account);
	AccountEntity update(AccountDto account);
	AccountEntity delete(AccountEntity account);
	Double getBalance(String accountNumber);
	AccountEntity updateBalance(String accountNumber, Double result);
}
