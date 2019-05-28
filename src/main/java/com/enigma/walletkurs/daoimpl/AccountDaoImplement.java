package com.enigma.walletkurs.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import org.springframework.transaction.annotation.Transactional;

public class AccountDaoImplement implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

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
    public float getBalance(String accountNumber) {
        float balance;
        AccountEntity account = entityManager.find(AccountEntity.class, accountNumber);
        balance = account.getBalance();
        return balance;
    }

    @Transactional
    @Override
    public AccountEntity updateBalance(String accountNumber, float balance) {
        AccountEntity account = entityManager.find(AccountEntity.class, accountNumber);
        account.setBalance(balance);
        return entityManager.merge(account);
    }

    @Override
    public List<AccountEntity> getAccountsByCustomerNumber(CustomerEntity customerNumber) {
        TypedQuery<AccountEntity> query = entityManager.createQuery("FROM AccountEntity e WHERE e.customerNumber = :cif",
                AccountEntity.class);
        query.setParameter("cif", customerNumber);
        return query.getResultList();
    }

}
