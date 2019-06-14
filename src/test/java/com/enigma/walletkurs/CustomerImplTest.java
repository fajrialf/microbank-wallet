package com.enigma.walletkurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.LoginDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerImplTest {

	@Autowired
	CustomerDao cusDao;

	@Before
	public void setUp() {
		for (int i = 0; i < 5; i++) {
			CustomerDto tempcus= new CustomerDto();
			tempcus.setBirthDate(new Date(i+1,i+2,i+3));
			tempcus.setCustomerNumber("cust "+i);
			tempcus.setFirstName("fname "+i);
			tempcus.setLastName("lname "+i);
			tempcus.setEmail("email "+i);
			tempcus.setPassword("pass"+i);
			cusDao.create(tempcus);
		}
	}
	
	@Test
	public void inputcustomer() {
		CustomerDto newcus = new CustomerDto();
		newcus.setFirstName("First name");
		newcus.setLastName("Last name");
		newcus.setCustomerNumber("c-01");
		cusDao.create(newcus);
		assertNotNull(cusDao.getByCustomerNumber("c-01"));
	}
	
	@Test
	public void updatecustomer() {
		CustomerEntity newcus=cusDao.getByCustomerNumber("cust 2");
		CustomerDto  upcust= new CustomerDto();
		newcus.setFirstName("fajri");
		upcust.setFirstName(newcus.getFirstName());
		upcust.setBirthDate(newcus.getBirthDate());
		upcust.setCustomerNumber(newcus.getCustomerNumber());
		upcust.setLastName(newcus.getLastName());
		upcust.setGender(newcus.getGender());
		upcust.setEmail(newcus.getEmail());
		upcust.setMotherName(newcus.getMotherName());
		upcust.setNik(newcus.getNik());
		upcust.setPassword(newcus.getPassword());
		cusDao.update(upcust);
		assertEquals(newcus.getFirstName(), cusDao.getByCustomerNumber("cust 2").getFirstName());
	}
	
	@Test
	public void deletecustomer() {
		CustomerEntity delcus = cusDao.getByCustomerNumber("cust 2");
		cusDao.delete(delcus);
		assertNull(cusDao.getByCustomerNumber("cust 2"));
	}
	
	@Test
	public void login() throws NotFoundException {
		LoginDto login =new LoginDto();
		login.setEmail("email 1");
		login.setPassword("pass1");
		assertNotNull(cusDao.login(login));
	}
	
	
	@Test(expected=NotFoundException.class)
	public void loginfail() throws NotFoundException {
		LoginDto login =new LoginDto();
		login.setEmail("emaila");
		login.setPassword("pass1");
		cusDao.login(login);
	}
}
