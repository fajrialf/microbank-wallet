package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.repository.AccountRepository;

public class AccountDaoImplement implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountRepository accountrepo;
    
    @Override
    public AccountEntity getByAccountNumber(String accountNumber) {
        return entityManager.find(AccountEntity.class, accountNumber);
    }

    @Transactional
    @Override
    public AccountEntity create(AccountEntity account) {
        AccountEntity acc = entityManager.merge(account);
        return acc;
    }

    @Transactional
    @Override
    public AccountEntity update(AccountEntity account) {
        AccountEntity acc = entityManager.merge(account);
        return acc;
    }

    @Transactional
    @Override
    public AccountEntity delete(AccountEntity account) {
        entityManager.remove(account);
        return account;
    }

    @Transactional
    @Override
    public Double getBalance(String accountNumber) {
        Double balance;
        AccountEntity account = entityManager.find(AccountEntity.class, accountNumber);
        balance = account.getBalance();
        return balance;
    }

    @Transactional
    @Override
    public AccountEntity updateBalance(String accountNumber, Double balance) {
        AccountEntity account = entityManager.find(AccountEntity.class, accountNumber);
        account.setBalance(balance);
        return entityManager.merge(account);
    }

	@Override
	public List<AccountEntity> getAccountsByCustomerNumber(String custnum) {
		List<AccountEntity>listaccount=accountrepo.findByCustomerNumberCustomerNumber(custnum);
		
		return listaccount;
	}

}
