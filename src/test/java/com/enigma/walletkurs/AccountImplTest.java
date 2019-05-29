package com.enigma.walletkurs;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountImplTest {

	@Autowired
	AccountDao accdao;
	
	@Autowired
	CustomerDao cusdao;
	
	@Before
	public void setUp() {
		for (int j=0;j < 5;j++) {
			CustomerEntity cust = new CustomerEntity();
			cust.setBirthDate(new Date(2019-05-j));
			cust.setCustomerNumber("cust "+j);
			cusdao.create(cust);
		}
		for (int i = 0; i < 5; i++) {
			AccountEntity newacc= new AccountEntity();
			CustomerEntity newcus= new CustomerEntity();
			newacc.setAccountName("acc "+i);
			newacc.setAccountNumber("accnum "+i);
			newacc.setBalance(300+i+.0);
			newcus.setCustomerNumber("cust "+i);
			newacc.setCustomerNumber(newcus);
			accdao.create(newacc);
		}
	}
	
	@Test
	public void getbalance() {
		assertNotNull(accdao.getBalance("accnum 2").doubleValue());
	}

	@Test
	public void getbycustomer() {
		assertNotNull(accdao.getAccountsByCustomerNumber("cust 5"));
	}
	
}
