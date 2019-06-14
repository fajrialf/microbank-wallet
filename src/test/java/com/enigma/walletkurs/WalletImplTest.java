package com.enigma.walletkurs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.AccountTypeEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.AccountDto;
import com.enigma.walletkurs.models.dto.AccountTypeDto;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.WalletAccountDto;
import com.enigma.walletkurs.models.dto.WalletDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WalletImplTest {

	@Autowired
	WalletDao walletdao;
	
	@Autowired
	private CustomerDao cusdao;

	@Autowired
	private AccountDao accdao;
	
	@Autowired
	private AccountTypeDao at;
	
	@Transactional
	@Before
	public void setUp() throws ExistException {
		AccountTypeEntity acct1= new AccountTypeEntity();
		acct1.setCode("at 1");
		acct1.setDescription("main");
		at.input(acct1);
		
		AccountTypeEntity acct2= new AccountTypeEntity();
		acct2.setCode("at 2");
		acct2.setDescription("virtual");
		at.input(acct2);

		AccountTypeEntity acct3= new AccountTypeEntity();
		acct3.setCode("at 3");
		acct3.setDescription("sub");
		at.input(acct3);
		
		AccountTypeDto acct4= new AccountTypeDto();
		acct4.setAccountType(1);
		acct4.setCode("at 1");
		acct4.setDescription("main");
		
		for (int j=0 ;j< 7;j++) {
			CustomerDto cusen= new CustomerDto();
			cusen.setCustomerNumber("customer "+j);
			cusen.setFirstName("first "+j);
			cusen.setLastName("last "+j);
			cusdao.create(cusen);
		}
		for (int h=0 ;h< 7;h++) {
			AccountDto accen = new AccountDto();
			accen.setAccountNumber("acc "+h);
			accen.setAccountType(acct4);
			accen.setCustomerNumber(new CustomerDto("customer "+h));
			accdao.create(accen);
		}
		for (int i = 0; i < 5; i++) {
			CustomerDto newcust= new CustomerDto();
			newcust.setCustomerNumber("customer "+ i);
			WalletDto wallen= new WalletDto();
			wallen.setDescription("ini desc "+ i);
			wallen.setCustomerNumber(newcust);
			walletdao.createwallet(wallen);
		}
	}
	
	@Test(expected=ExistException.class)
	public void inpuwallet() throws ExistException{
		WalletDto newwal= new WalletDto();
		newwal.setDescription("ini desc 2");
		walletdao.createwallet(newwal);
	}

	@Test
	public void inputwalletsuccess() throws ExistException{
		WalletDto newwal= new WalletDto();
		newwal.setDescription("desc baru");
		CustomerDto newcus= new CustomerDto();
		newcus.setCustomerNumber("customer 5");
		newwal.setCustomerNumber(newcus);
		assertNotNull(walletdao.createwallet(newwal));
		List<WalletEntity>newwall= new ArrayList<WalletEntity>();
		assertNotEquals(newwall,walletdao.getAllWalletByCustomer("customer 5"));
	}
	
	@Test
	public void registerwallet() {
		WalletAccountDto walac= new WalletAccountDto();
		AccountDto newacc= new AccountDto();
		WalletDto newwal= new WalletDto();
		newacc.setAccountNumber("acc 2");
		newwal.setWalletId("W-002");
		walac.setAccountNumber(newacc);
		walac.setWalletId(newwal);
		walac.setId(2);
		assertNotNull(walletdao.registeraccount(walac));
		List<WalletAccountEntity>newwalac= new ArrayList<WalletAccountEntity>();
		assertNotEquals(newwalac,walletdao.getAllWalletAccountByWallet("W-002"));
	}
	
	@Test
	public void deletewal()throws Exception{
		walletdao.deletewallet("W-001");
		assertNull(walletdao.getwalletById("W-001"));
	}
	
	@Test(expected=Exception.class)
	public void deletewalfailed() throws Exception{
		walletdao.deletewallet("ini idw 6");
	}
}
