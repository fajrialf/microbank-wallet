package com.enigma.walletkurs;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.dao.TradingDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.dao.TransactionTypeDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.AccountTypeEntity;
import com.enigma.walletkurs.models.ExchangeEntity;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.TransactionTypeEntity;
import com.enigma.walletkurs.models.dto.AccountDto;
import com.enigma.walletkurs.models.dto.AccountTypeDto;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.TradingDto;
import com.enigma.walletkurs.models.dto.TransactionDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TradingDaoTest {

	@Autowired
	TradingDao tradedao;
	
	@Autowired
	AccountDao accDao;
	
	@Autowired
	CustomerDao custDao;
	
	@Autowired
	ExchangeDao exhangeDao;
	
	@Autowired
	AccountTypeDao at;
	
	@Autowired
	TransactionDao transDao;
	
	@Autowired
	TransactionTypeDao transtype;
	
	@Transactional
	@Before
	public void setUp() throws ExistException, EntityNotFoundException, InsufficientAmountException {
		AccountTypeEntity acct1= new AccountTypeEntity();
		acct1.setCode("001");
		acct1.setDescription("Main");
		at.input(acct1);

		AccountTypeEntity acct2= new AccountTypeEntity();
		acct2.setCode("002");
		acct2.setDescription("Virtual");
		at.input(acct2);
	
		TransactionTypeEntity ttype=new TransactionTypeEntity();
		ttype.setDescription("open account");
		ttype.setTransactionType("006");
		transtype.input(ttype);
		
		TransactionTypeEntity ttype1=new TransactionTypeEntity();
		ttype1.setDescription("buy");
		ttype1.setTransactionType("004");
		transtype.input(ttype1);

		TransactionTypeEntity ttype2=new TransactionTypeEntity();
		ttype2.setDescription("sell");
		ttype2.setTransactionType("005");
		transtype.input(ttype2);
		

		TransactionTypeEntity ttype3=new TransactionTypeEntity();
		ttype3.setDescription("topup acc");
		ttype3.setTransactionType("002");
		transtype.input(ttype3);
		

		TransactionTypeEntity ttype4=new TransactionTypeEntity();
		ttype4.setDescription("top wall");
		ttype4.setTransactionType("003");
		transtype.input(ttype);
		for (int j=0 ;j< 8;j++) {
			CustomerDto tempcus= new CustomerDto();
			tempcus.setNik("nik "+j);
			tempcus.setBirthDate(new Date(j+1,j+2,j+3));
			tempcus.setFirstName("fname "+j);
			tempcus.setLastName("lname "+j);
			tempcus.setEmail("email "+j);
			tempcus.setPassword("pass"+j);
			custDao.create(tempcus);
		}
		for (int h=0 ;h< 7;h++) {
			AccountDto accen = new AccountDto();
			AccountTypeDto acct4= new AccountTypeDto();
			acct4.setCode("002");
			accen.setAccountType(acct4);
			accen.setAccountName("nama "+h);
			accen.setCustomerNumber(new CustomerDto("CS-00"+(h+1)));
			accDao.create(accen);
		}
		for (int i=0;i<3;i++) {
			ExchangeEntity tempexc= new ExchangeEntity();
			tempexc.setBuy(14000.0+i);
			tempexc.setSell(14300.0+i);
			tempexc.setcCy1("IDR");
			tempexc.setcCy2("USD");
			tempexc.setDate(new java.util.Date());
			exhangeDao.createentity(tempexc);
		}
		
		TransactionDto temptrans= new TransactionDto();
		temptrans.setAccountNumberCredit("ACC-002");
		temptrans.setAccountNumberDebit("0");
		temptrans.setAmount(200000.0);
		transDao.topUp(temptrans);
		

		TransactionDto temptrans1= new TransactionDto();
		temptrans1.setAccountNumberCredit("ACC-003");
		temptrans1.setAccountNumberDebit("0");
		temptrans1.setAmount(200000.0);
		transDao.topUp(temptrans1);
	}
	
	@Test
	public void topuptest() throws EntityNotFoundException {
		TransactionDto temptrans= new TransactionDto();
		temptrans.setAccountNumberCredit("ACC-001");
		temptrans.setAccountNumberDebit("0");
		temptrans.setAmount(200000.0);
		transDao.topUp(temptrans);
		assertEquals(200000, accDao.getByAccountNumber("ACC-001").getBalance().intValue());
	}
	
	@Test
	public void tradebuytest() throws InsufficientAmountException {
		TradingDto temptrade= new TradingDto();
		temptrade.setAmount(3.0);
		temptrade.setTradingId("CS-002");
		temptrade.setCcy("USD");
		temptrade.setType("b");
		tradedao.buyAsset(temptrade);
		assertEquals(157094, accDao.getBalance("ACC-002").intValue());
	}
	
	@Test(expected=InsufficientAmountException.class)
	public void tradebuyfail() throws InsufficientAmountException {
		TradingDto temptrade= new TradingDto();
		temptrade.setAmount(20.1);
		temptrade.setTradingId("CS-003");
		temptrade.setCcy("USD");
		temptrade.setType("b");
		tradedao.buyAsset(temptrade);
	}
	
	@Test
	public void tradeselltest() throws InsufficientAmountException, EntityNotFoundException {
		TradingDto temptrade1= new TradingDto();
		temptrade1.setAmount(5.0);
		temptrade1.setTradingId("CS-003");
		temptrade1.setCcy("USD");
		temptrade1.setType("b");
		tradedao.buyAsset(temptrade1);
		assertEquals(5, tradedao.totalBalance("CS-003").intValue());
		assertEquals(128490, accDao.getBalance("ACC-003").intValue());
		
		TradingDto temptrd=new TradingDto();
		temptrd.setAmount(3.0);
		temptrd.setType("s");
		temptrd.setTradingId("CS-003");
		temptrd.setCcy("USD");
		tradedao.sellAsset(temptrd);

		assertEquals(2, tradedao.totalBalance("CS-003").intValue());
		assertEquals(170496, accDao.getBalance("ACC-003").intValue());
	}
	
	@Test
	public void sumamount() throws InsufficientAmountException {		
	TradingDto temptrade1= new TradingDto();
	temptrade1.setAmount(5.0);
	temptrade1.setTradingId("CS-003");
	temptrade1.setCcy("USD");
	temptrade1.setType("b");
	tradedao.buyAsset(temptrade1);
	
	assertEquals(5, tradedao.totalBalance("CS-003").intValue());
	}
}
