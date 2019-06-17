package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.models.ExchangeEntity;

public class ExchangeDaoImpl implements ExchangeDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public ExchangeEntity createentity(ExchangeEntity exchange) {
		return em.merge(exchange);
	}

	@Override
	public List<ExchangeEntity> listRate() {
		// TODO Auto-generated method stub
		return null;
	}

}
