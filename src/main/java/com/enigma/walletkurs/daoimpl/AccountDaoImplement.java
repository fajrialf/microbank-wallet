package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;

public class AccountDaoImplement implements AccountDao{

	  @PersistenceContext
	    private EntityManager entityManager;

	@Override
	public AccountEntity getByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return entityManager.find(AccountEntity.class, accountNumber);
	}

	@Override
	public AccountEntity addAccount(AccountEntity account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountEntity updateAccount(AccountEntity account) {
		// TODO Auto-generated method stub
		return null;
	}


	


	


}
