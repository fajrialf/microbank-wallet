package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.models.ExchangeEntity;

public class ExchangeDaoImpl implements ExchangeDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public ExchangeEntity createentity(ExchangeEntity exchange) {
		Query query= em.createQuery("from ExchangeEntity order by rateId desc");
		query.setMaxResults(1);
		if (!query.getResultList().isEmpty()) {
			ExchangeEntity tempxexc= (ExchangeEntity) query.getSingleResult();
			if (tempxexc.getBuy().equals(exchange.getBuy()) && tempxexc.getSell().equals(exchange.getSell())) {
				return null;
			}
		}
		return em.merge(exchange);
	}

	@Override
	public List<ExchangeEntity> listRate() {
		Query query=em.createQuery("from ExchangeEntity order by rateId asc");
		return query.getResultList();
	}
}
