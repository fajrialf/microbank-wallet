package com.enigma.walletkurs.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.enigma.walletkurs.dao.TransactionTypeDao;
import com.enigma.walletkurs.models.TransactionTypeEntity;

public class TransactionTypeDaoImpl implements TransactionTypeDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public TransactionTypeEntity input(TransactionTypeEntity transtype) {
		return em.merge(transtype);
	}

}
