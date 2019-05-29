package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.models.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TransactionDaoImplement implements TransactionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public TransactionEntity topUp(TransactionEntity transaction) {
        TransactionEntity topUp = entityManager.merge(transaction);
        float balance = accountDao.getBalance(transaction.getAccountNumberCredit());
        float result = balance + transaction.getAmount();
        accountDao.updateBalance(transaction.getAccountNumberCredit(), result);
        return topUp;
    }

    @Transactional
    @Override
    public TransactionEntity transfer(TransactionEntity transaction) {
        float oldBalanceCredit, oldBalanceDebit, newBalanceCredit, newBalanceDebit;
        TransactionEntity transfer = entityManager.merge(transaction);
        oldBalanceCredit = accountDao.getBalance(transaction.getAccountNumberCredit());
        oldBalanceDebit = accountDao.getBalance(transaction.getAccountNumberDebit());

        newBalanceCredit = oldBalanceCredit + transaction.getAmount();
        newBalanceDebit = oldBalanceDebit - transaction.getAmount();

        accountDao.updateBalance(transaction.getAccountNumberCredit(), newBalanceCredit);
        accountDao.updateBalance(transaction.getAccountNumberDebit(), newBalanceDebit);
        return transfer;
    }

    @Transactional
    @Override
    public TransactionEntity withdraw(TransactionEntity transaction) {
        TransactionEntity withdraw = entityManager.merge(transaction);
        float balance = accountDao.getBalance(transaction.getAccountNumberDebit());
        float result = balance - transaction.getAmount();
        accountDao.updateBalance(transaction.getAccountNumberDebit(), result);
        return withdraw;
    }

    @Override
    public TransactionEntity getTransactionById(String transactionID) {
        return entityManager.find(TransactionEntity.class, transactionID);
    }

    @Override
    public TransactionEntity getTransactionsByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public TransactionEntity getTransactionsByCustomerNumber(String customerNumber) {
        return null;
    }
}
