package com.enigma.walletkurs.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.enigma.walletkurs.dao.AccountDao;
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
    
    @Override
    public AccountEntity getByAccountNumber(String accountNumber) {
        return entityManager.find(AccountEntity.class, accountNumber);
    }

    @Transactional
    @Override
    public AccountEntity create(AccountDto account) {
    	AccountEntity tempacc= new AccountEntity();
    	AccountTypeEntity acctype= new AccountTypeEntity();
    	CustomerEntity custtemp=new CustomerEntity();
    	custtemp.setCustomerNumber(account.getCustomerNumber().getCustomerNumber());
    	acctype.setCode(account.getAccountType().getCode());
    	tempacc.setAccountName(account.getAccountName());
    	tempacc.setAccountNumber(account.getAccountNumber());
    	tempacc.setAccountType(acctype);
    	tempacc.setBalance(account.getBalance());
    	tempacc.setCustomerNumber(custtemp);
    	tempacc.setOpenDate(new Date());
        AccountEntity acc = entityManager.merge(tempacc);
        return acc;
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
        AccountEntity acc = entityManager.merge(tempacc);
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
	public List<AccountEntity> getAccountsByCustomerNumber(String string) {
		// TODO Auto-generated method stub
		List<AccountEntity>listaccount=accrepo.findByCustomerNumberCustomerNumber(string);
		return listaccount;
	}

}
