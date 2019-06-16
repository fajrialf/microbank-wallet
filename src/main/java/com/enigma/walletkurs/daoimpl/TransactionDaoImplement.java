
package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.additional.Autogenerateid;
import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.TransactionEntity;
import com.enigma.walletkurs.models.TransactionTypeEntity;
import com.enigma.walletkurs.models.dto.TransactionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.Date;
import java.util.List;

public class TransactionDaoImplement implements TransactionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public TransactionEntity topUp(TransactionDto transaction) throws EntityNotFoundException {
        Double balance = accountDao.getBalance(transaction.getAccountNumberCredit());
		TransactionTypeEntity transtype= new TransactionTypeEntity();
		if (transaction.getAccountNumberCredit().contains("w")) {
			transtype.setTransactionType("003");
		}
		transtype.setTransactionType("002");
        if (balance != null) {
            Double balance2 = accountDao.getBalance(transaction.getAccountNumberDebit());
            if (balance2!=null) {
            double result = balance + transaction.getAmount();
            double result2 = balance2 - transaction.getAmount();
            accountDao.updateBalance(transaction.getAccountNumberCredit(), result);
            accountDao.updateBalance(transaction.getAccountNumberDebit(), result2);
            }
        }else {
        	throw new EntityNotFoundException(44, "Error,Account not found");
        }
        TransactionEntity temptrans= new TransactionEntity();
        temptrans.setTransactionId(generateid());
        temptrans.setAccountNumberCredit(transaction.getAccountNumberCredit());
        temptrans.setAccountNumberDebit(transaction.getAccountNumberDebit());
        temptrans.setAmount(transaction.getAmount());
        temptrans.setDate(new Date());
        temptrans.setTransactionType(transtype);
        TransactionEntity topUp = entityManager.merge(temptrans);
        return topUp;
    }

     String generateid() {
    	 String temptrans;
        Query query= entityManager.createQuery("from TransactionEntity order by transactionId desc");
        query.setMaxResults(1);
        if (query.getResultList().isEmpty()) {
            temptrans="TRX-001";
        }else {
        	TransactionEntity trans = (TransactionEntity) query.getSingleResult();
            Autogenerateid transactionid = new Autogenerateid("TRX-", trans.getTransactionId(), "0", 2);
            temptrans=transactionid.generatedid();
        }
        return temptrans;
    }
     
    @Transactional
    @Override
    public TransactionEntity transfer(TransactionDto transaction) throws EntityNotFoundException, InsufficientAmountException {
        Double oldBalanceCredit;
		Double oldBalanceDebit;
		Double newBalanceCredit;
		Double newBalanceDebit;
		TransactionTypeEntity transtype= new TransactionTypeEntity();
		transtype.setTransactionType("001");
        oldBalanceCredit = accountDao.getBalance(transaction.getAccountNumberCredit());
        oldBalanceDebit = accountDao.getBalance(transaction.getAccountNumberDebit());
        if (oldBalanceCredit == null || oldBalanceDebit == null) {
        	throw new EntityNotFoundException(44, "Error,Account not found");
        }else {
            newBalanceDebit = oldBalanceDebit - transaction.getAmount();
        	if (newBalanceDebit <0) {
        		throw new InsufficientAmountException(52, "Amount is not enough");
        	}
            newBalanceCredit = oldBalanceCredit + transaction.getAmount();
        }
        accountDao.updateBalance(transaction.getAccountNumberCredit(), newBalanceCredit);
        accountDao.updateBalance(transaction.getAccountNumberDebit(), newBalanceDebit);
        TransactionEntity temptrans= new TransactionEntity();
        temptrans.setTransactionId(generateid());
        temptrans.setAccountNumberCredit(transaction.getAccountNumberCredit());
        temptrans.setAccountNumberDebit(transaction.getAccountNumberDebit());
        temptrans.setAmount(transaction.getAmount());
        temptrans.setDate(new Date());
        temptrans.setTransactionType(transtype);
        TransactionEntity transfer = entityManager.merge(temptrans);
        return transfer;
    }

    @Transactional
    @Override
    public TransactionEntity withdraw(TransactionDto transaction) throws EntityNotFoundException, InsufficientAmountException {
        Double balance = accountDao.getBalance(transaction.getAccountNumberDebit());
        if (balance == null) {
        	throw new EntityNotFoundException(44, "Error,Account not found");
        }else {
            Double result = balance - transaction.getAmount();
        	if (result <0 ) {
        		throw new InsufficientAmountException(52, "Balance not enough");
        	}
            accountDao.updateBalance(transaction.getAccountNumberDebit(), result);
        }        
        TransactionEntity temptrans= new TransactionEntity();
        temptrans.setAccountNumberCredit(transaction.getAccountNumberCredit());
        temptrans.setAmount(transaction.getAmount());
        temptrans.setDate(new Date());
        temptrans.getTransactionType().setTransactionType(transaction.getTransactionType().getTransactionType());
        TransactionEntity withdraw = entityManager.merge(temptrans);
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

	@Override
	public TransactionEntity openaccount(TransactionDto transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity buyAsset(TransactionDto transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity sellAsset(TransactionDto transaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
