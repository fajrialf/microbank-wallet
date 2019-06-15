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
import com.enigma.walletkurs.exception.ExistException;
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
	public void setUp() throws ExistException {
		for (int i = 0; i < 5; i++) {
			CustomerDto tempcus= new CustomerDto();
			tempcus.setNik("nik "+i);
			tempcus.setBirthDate(new Date(i+1,i+2,i+3));
			tempcus.setFirstName("fname "+i);
			tempcus.setLastName("lname "+i);
			tempcus.setEmail("email "+i);
			tempcus.setPassword("pass"+i);
			cusDao.create(tempcus);
		}
	}
	
	@Test
	public void inputcustomer() throws ExistException {
		CustomerDto newcus = new CustomerDto();
		newcus.setFirstName("First name");
		newcus.setLastName("Last name");
		newcus.setEmail("email lo");
		newcus.setPassword("passti");
		newcus.setNik("nikah");
		newcus.setBirthDate(new Date(2019,03,12));
		cusDao.create(newcus);
		assertNotNull(cusDao.getByCustomerNumber("CS-006"));
	}
	
	
	@Test
	public void updatecustomer() throws ExistException {
		CustomerEntity newcus=cusDao.getByCustomerNumber("CS-002");
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
		assertEquals(newcus.getFirstName(), cusDao.getByCustomerNumber("CS-002").getFirstName());
	}
	
	@Test
	public void deletecustomer() {
		CustomerEntity delcus = cusDao.getByCustomerNumber("CS-002");
		cusDao.delete(delcus);
		assertNull(cusDao.getByCustomerNumber("CS-002"));
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
	
	@Test(expected=ExistException.class)
	public void emailexist() throws ExistException {
		CustomerDto newcus = new CustomerDto();
		newcus.setFirstName("First name");
		newcus.setLastName("Last name");
		newcus.setEmail("email 1");
		cusDao.create(newcus);		
	}
}
