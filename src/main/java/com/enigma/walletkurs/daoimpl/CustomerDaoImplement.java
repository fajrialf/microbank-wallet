package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.LoginDto;
import com.enigma.walletkurs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDaoImplement implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public CustomerEntity getByCustomerNumber(String customerNumber) {
        return entityManager.find(CustomerEntity.class, customerNumber);
    }

    @Transactional
    @Override
    public CustomerEntity create(CustomerDto customer) {
    	CustomerEntity tempcust= new CustomerEntity();
    	tempcust.setBirthDate(customer.getBirthDate());
    	tempcust.setCustomerNumber(customer.getCustomerNumber());
    	tempcust.setEmail(customer.getEmail());
    	tempcust.setFirstName(customer.getFirstName());
    	tempcust.setLastName(customer.getLastName());
    	tempcust.setGender(customer.getGender());
    	tempcust.setMotherName(customer.getMotherName());
    	tempcust.setNik(customer.getNik());
    	tempcust.setPassword(customer.getPassword());
        CustomerEntity data = entityManager.merge(tempcust);
        return data;
    }

    @Transactional
    @Override
    public CustomerEntity update(CustomerDto customer) {
    	CustomerEntity tempcust= new CustomerEntity();
    	tempcust.setBirthDate(customer.getBirthDate());
    	tempcust.setCustomerNumber(customer.getCustomerNumber());
    	tempcust.setEmail(customer.getEmail());
    	tempcust.setFirstName(customer.getFirstName());
    	tempcust.setLastName(customer.getLastName());
    	tempcust.setGender(customer.getGender());
    	tempcust.setMotherName(customer.getMotherName());
    	tempcust.setNik(customer.getNik());
    	tempcust.setPassword(customer.getPassword());
        CustomerEntity data = entityManager.merge(tempcust);
        return data;
    }

    @Transactional
    @Override
    public CustomerEntity delete(CustomerEntity customer) {
        entityManager.remove(customer);
        return customer;
    }

    @Override
    public CustomerEntity login(LoginDto customer) throws NotFoundException {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            CustomerEntity user = customerRepository.findByEmail(customer.getEmail());
            if (customer.getPassword().equals(user.getPassword())) {
                return user;
            } else {
                throw new NotFoundException(44, "Wrong Email Or Password!");
            }
        } else {
            throw new NotFoundException(44, "Wrong Email Or Password!");
        }
    }
}
