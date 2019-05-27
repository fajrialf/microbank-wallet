package com.enigma.walletkurs.dao;

import java.util.List;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;

public interface AccountDao {
	AccountEntity getByAccountNumber(String accountNumber);
	
	AccountEntity addAccount(AccountEntity account);

	AccountEntity updateAccount(AccountEntity account);

	List<AccountEntity> getAccountsByCIF(CustomerEntity customerNumber)  ;


}
