package com.enigma.walletkurs;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.models.CustomerEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerImplTest {

	@Autowired
	CustomerDao cusDao;

	@Before
	public void setUp() {
		for (int i = 0; i < 5; i++) {
			CustomerEntity tempcus= new CustomerEntity();
			tempcus.setBirthDate(new Date(i+1,i+2,i+3));
			tempcus.setCustomerNumber("cust "+i);
			tempcus.setFirstName("fname "+i);
			tempcus.setLastName("lname "+i);
			cusDao.create(tempcus);
		}
	}
	
	@Test
	public void inputcustomer() {
		CustomerEntity newcus = new CustomerEntity();
		newcus.setFirstName("First name");
		newcus.setLastName("Last name");
		newcus.setCustomerNumber("c-01");
		cusDao.create(newcus);
		assertNotNull(cusDao.getByCustomerNumber("c-01"));
	}
	
	@Test
	public void updatecustomer() {
		CustomerEntity newcus=cusDao.getByCustomerNumber("cust 2");
		newcus.setFirstName("fajri");
		cusDao.update(newcus);
		assertEquals(newcus.getFirstName(), cusDao.getByCustomerNumber("cust 2").getFirstName());
	}
	
	@Test
	public void deletecustomer() {
		CustomerEntity delcus = cusDao.getByCustomerNumber("cust 2");
		cusDao.delete(delcus);
		CustomerEntity f = new CustomerEntity();
		assertNull(cusDao.getByCustomerNumber("cust 2"));
	}
}
