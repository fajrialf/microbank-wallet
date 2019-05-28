package com.enigma.walletkurs.dao;

import java.util.List;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;

public interface AccountDao {
	List<AccountEntity> getAccountsByCustomerNumber(CustomerEntity customerNumber)  ;
	AccountEntity getByAccountNumber(String accountNumber);
	AccountEntity create(AccountEntity account);
	AccountEntity update(AccountEntity account);
	AccountEntity delete(AccountEntity account);
}
