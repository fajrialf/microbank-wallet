package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.models.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
    public List<TransactionEntity> getTransactionsByAccountNumber(String accountNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransactionEntity> query = builder.createQuery(TransactionEntity.class);
        Root<TransactionEntity> root = query.from(TransactionEntity.class);

        query.select(root).where(
                builder.or(
                        builder.like(root.get("accountNumberCredit"), accountNumber),
                        builder.like(root.get("accountNumberDebit"), accountNumber)
                        )
        );
        Query q = entityManager.createQuery(query);
        return q.getResultList();
    }

}
