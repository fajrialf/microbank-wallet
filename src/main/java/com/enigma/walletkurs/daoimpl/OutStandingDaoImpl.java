package com.enigma.walletkurs.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.enigma.walletkurs.dao.OutstandingDao;
import com.enigma.walletkurs.models.OutStandingEntity;

public class OutStandingDaoImpl implements OutstandingDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public OutStandingEntity createoutstanding(OutStandingEntity outstanding) {
		return em.merge(outstanding);
	}

}
