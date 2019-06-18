package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.models.AccountTypeEntity;

public class AccountTypeDaoImpl implements AccountTypeDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AccountTypeEntity input(AccountTypeEntity acctype) {
		return em.merge(acctype);
	}

	@Override
	public List<AccountTypeEntity> getListAccountType() {
		Query query = em.createQuery("From AccountTypeEntity ORDER BY code ASC");
		return query.getResultList();
	}
}
