package com.enigma.walletkurs.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.models.AccountTypeEntity;

public class AccountTypeDaoImpl implements AccountTypeDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AccountTypeEntity input(AccountTypeEntity acctype) {
		return em.merge(acctype);
	}
}
