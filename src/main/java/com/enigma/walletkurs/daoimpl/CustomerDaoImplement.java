package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.additional.Autogenerateid;
import com.enigma.walletkurs.additional.MD5;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.LoginDto;
import com.enigma.walletkurs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CustomerDaoImplement implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MD5 encodeMD5;
    
    @Transactional
    @Override
    public CustomerEntity getByCustomerNumber(String customerNumber) {
        return entityManager.find(CustomerEntity.class, customerNumber);
    }

    @Transactional
    @Override
    public CustomerEntity create(CustomerDto customer) throws ExistException {
    	if (customerRepository.existsByNik(customer.getNik())) {
    		throw new ExistException(46, "Error,Nik is exist");
    	}
    	if (customerRepository.existsByEmail(customer.getEmail())) {
    		throw new ExistException(46, "Error,Email is exist");
    	}
    	CustomerEntity tempcust= new CustomerEntity();
    	tempcust.setBirthDate(customer.getBirthDate());
    	tempcust.setEmail(customer.getEmail());
    	tempcust.setFirstName(customer.getFirstName());
    	tempcust.setLastName(customer.getLastName());
    	tempcust.setGender(customer.getGender());
    	tempcust.setMotherName(customer.getMotherName());
    	tempcust.setNik(customer.getNik());
    	tempcust.setPassword(encodeMD5.getSecurePassword(customer.getPassword()));
        Query query = entityManager.createQuery("FROM CustomerEntity order by customerNumber desc");
        query.setMaxResults(1);

        if (query.getResultList().isEmpty()) {
            tempcust.setCustomerNumber("CS-001");
        }else {
            CustomerEntity cust = (CustomerEntity) query.getSingleResult();
            Autogenerateid customerNumber = new Autogenerateid("CS-", cust.getCustomerNumber(), "0", 2);
            tempcust.setCustomerNumber(customerNumber.generatedid());
        }

        CustomerEntity data = entityManager.merge(tempcust);
        return data;
    }

    @Transactional
    @Override
    public CustomerEntity update(CustomerDto customer) throws ExistException {
    	CustomerEntity tempcust= new CustomerEntity();
    	tempcust.setBirthDate(customer.getBirthDate());
    	tempcust.setEmail(customer.getEmail());
    	tempcust.setFirstName(customer.getFirstName());
    	tempcust.setLastName(customer.getLastName());
    	tempcust.setGender(customer.getGender());
    	tempcust.setMotherName(customer.getMotherName());
    	tempcust.setNik(customer.getNik());
    	tempcust.setPassword(encodeMD5.getSecurePassword(customer.getPassword()));
    	tempcust.setCustomerNumber(customer.getCustomerNumber());
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
            
            if (encodeMD5.getSecurePassword(customer.getPassword()).equals(user.getPassword())) {

                return user;
            } else {
                throw new NotFoundException(44, "Wrong Email Or Password!");
            }
        } else {
            throw new NotFoundException(44, "Wrong Email Or Password!");
        }
    }
}
