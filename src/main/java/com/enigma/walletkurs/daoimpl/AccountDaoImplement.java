package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.repository.AccountRepository;

public class AccountDaoImplement implements AccountDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountEntity getByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return entityManager.find(AccountEntity.class, accountNumber);
	}

	@Override
	public AccountEntity addAccount(AccountEntity account) {
		// TODO Auto-generated method stub
		AccountEntity acc = entityManager.merge(account);
		return acc;
	}

	@Override
	public AccountEntity updateAccount(AccountEntity account) {
		AccountEntity acc = entityManager.merge(account);
		return acc;
	}

	@Override

	public List<AccountEntity> getAccountsByCIF(CustomerEntity customerNumber) {
		TypedQuery<AccountEntity> query = entityManager.createQuery("FROM AccountEntity e WHERE e.customerNumber = :cif",
				AccountEntity.class);
		query.setParameter("cif", customerNumber);
		return query.getResultList();
	}

}
