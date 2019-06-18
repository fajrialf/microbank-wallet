package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.models.AccountTypeEntity;

import java.util.List;

public interface AccountTypeDao {
	AccountTypeEntity input (AccountTypeEntity acctype);
	List<AccountTypeEntity> getListAccountType();
}
