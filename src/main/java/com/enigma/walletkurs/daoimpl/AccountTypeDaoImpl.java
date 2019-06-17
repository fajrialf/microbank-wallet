package com.enigma.walletkurs.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.models.AccountTypeEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
