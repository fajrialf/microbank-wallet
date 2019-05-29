package com.enigma.walletkurs.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.models.TransactionEntity;

public class TransactionDaoImplement implements TransactionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public TransactionEntity topUp(TransactionEntity transaction) {
        TransactionEntity topUp = entityManager.merge(transaction);
//        float balance = accountDao.getBalance(transaction.getAccountNumberCredit());
//        float result = balance + transaction.getAmount();
//        accountDao.updateBalance(transaction.getAccountNumberCredit(),result);
        return topUp;
    }

    @Transactional
    @Override
    public TransactionEntity transfer(TransactionEntity transaction) {
        TransactionEntity transfer = entityManager.merge(transaction);
        return transfer;
    }

    @Transactional
    @Override
    public TransactionEntity widthraw(TransactionEntity transaction) {
        TransactionEntity withdraw = entityManager.merge(transaction);
        return withdraw;
    }

    @Override
    public TransactionEntity getTransactionById(String transactionID) {
        return entityManager.find(TransactionEntity.class, transactionID);
    }
}
