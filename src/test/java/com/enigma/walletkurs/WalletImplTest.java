package com.enigma.walletkurs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.WalletDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WalletImplTest {

	@Autowired
	WalletDao walletdao;
	
	@Autowired
	CustomerDao cusdao;
	

	@Autowired
	AccountDao accdao;
	
	@Before
	public void setUp() throws ExistException {
		for (int j=0 ;j< 7;j++) {
			CustomerEntity cusen= new CustomerEntity();
			cusen.setCustomerNumber("customer "+j);
			cusen.setFirstName("first "+j);
			cusen.setLastName("last "+j);
			cusdao.create(cusen);
		}
		for (int h=0 ;h< 7;h++) {
			AccountEntity accen = new AccountEntity();
			accen.setAccountNumber("acc "+h);
			accdao.create(accen);
		}
		for (int i = 0; i < 5; i++) {
			CustomerEntity newcust= new CustomerEntity();
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
		CustomerEntity newcus= new CustomerEntity();
		newcus.setCustomerNumber("customer 5");
		newwal.setCustomerNumber(newcus);
		assertNotNull(walletdao.createwallet(newwal));
		List<WalletEntity>newwall= new ArrayList<WalletEntity>();
		assertNotEquals(newwall,walletdao.getAllWalletByCustomer("customer 5"));
	}
	
	@Test
	public void registerwallet() {
		WalletAccountEntity walac= new WalletAccountEntity();
		AccountEntity newacc= new AccountEntity();
		WalletEntity newwal= new WalletEntity();
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
