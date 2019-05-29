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
		}
	}
}
