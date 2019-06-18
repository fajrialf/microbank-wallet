package com.enigma.walletkurs.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.enigma.walletkurs.additional.Autogenerateid;
import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.AccountTypeEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.AccountDto;
import com.enigma.walletkurs.repository.AccountRepository;

public class AccountDaoImplement implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountRepository accrepo;
    
    @Autowired
    private TransactionDao transDao;
    
    @Override
    public AccountEntity getByAccountNumber(String accountNumber) {
        return entityManager.find(AccountEntity.class, accountNumber);
    }

    @Transactional
    @Override
    public AccountEntity create(AccountDto account) throws ExistException {
    	AccountEntity tempacc= new AccountEntity();
    	AccountTypeEntity acctype= new AccountTypeEntity();
    	List<AccountEntity>listaccounts= accrepo.findByCustomerNumberCustomerNumber(account.getCustomerNumber().getCustomerNumber());
    	if (listaccounts!=null && listaccounts.size()==2) {
    		throw new ExistException(47, "Error,you have reached the maximum account create");
    	}
    	if (account.getAccountType() != null) {
        	acctype.setCode(account.getAccountType().getCode());
    	}else {
    	if (!accrepo.existsByAccountTypeDescriptionAndCustomerNumberCustomerNumber("main",account.getCustomerNumber().getCustomerNumber())) {
    		acctype.setCode("001");
    	}else {
    	if (!accrepo.existsByAccountTypeDescriptionAndCustomerNumberCustomerNumber("virtual",account.getCustomerNumber().getCustomerNumber())) {
    		acctype.setCode("002");
    	} 
    	}}
    	Query query = entityManager.createQuery("FROM AccountEntity order by accountNumber desc");
        query.setMaxResults(1);

        if (query.getResultList().isEmpty()) {
            tempacc.setAccountNumber("ACC-001");
        }else {
            AccountEntity acc = (AccountEntity) query.getSingleResult();
            Autogenerateid accountNumber = new Autogenerateid("ACC-", acc.getAccountNumber(), "0", 2);
            tempacc.setAccountNumber(accountNumber.generatedid());
        }
    	CustomerEntity custtemp=new CustomerEntity();
    	custtemp.setCustomerNumber(account.getCustomerNumber().getCustomerNumber());
    	tempacc.setAccountName(account.getAccountName());
    	tempacc.setAccountType(acctype);
    	tempacc.setBalance(0.0);
    	tempacc.setCustomerNumber(custtemp);
    	tempacc.setOpenDate(new Date());
    	transDao.openaccount(tempacc);
        return entityManager.merge(tempacc);
    }

    @Transactional
    @Override
    public AccountEntity update(AccountDto account) {
    	AccountEntity tempacc= new AccountEntity();
    	tempacc.setAccountName(account.getAccountName());
    	tempacc.setAccountNumber(account.getAccountNumber());
    	tempacc.getAccountType().setCode(account.getAccountType().getCode());
    	tempacc.setBalance(account.getBalance());
    	tempacc.getCustomerNumber().setCustomerNumber(account.getCustomerNumber().getCustomerNumber());
    	tempacc.setOpenDate(new Date());
        return entityManager.merge(tempacc);
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
        AccountEntity account = entityManager.find(AccountEntity.class, accountNumber);
        if (account == null) {
        	return null;
        }
        return account.getBalance();
    }

    @Transactional
    @Override
    public AccountEntity updateBalance(String accountNumber, Double balance) {
        AccountEntity account = entityManager.find(AccountEntity.class, accountNumber);
        account.setBalance(balance);
        return entityManager.merge(account);
    }

	@Override
	public List<AccountEntity> getAccountsByCustomerNumber(String string) {
		return accrepo.findByCustomerNumberCustomerNumber(string);
	}

	@Override
	public AccountEntity getByDescription(String accountNumber,String desc) {
		return accrepo.findByCustomerNumberCustomerNumberAndAccountTypeDescription(accountNumber, desc);
	}

}
