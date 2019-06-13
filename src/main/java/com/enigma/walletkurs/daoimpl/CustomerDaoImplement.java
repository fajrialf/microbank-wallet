package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.additional.Autogenerateid;
import com.enigma.walletkurs.additional.MD5;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

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
    public CustomerEntity create(CustomerEntity customer) {
        CustomerEntity temp = new CustomerEntity();

        temp.setFirstName(customer.getFirstName());
        temp.setLastName(customer.getLastName());
        temp.setBirthDate(customer.getBirthDate());
        temp.setGender(customer.getGender());
        temp.setMotherName(customer.getMotherName());
        temp.setNik(customer.getNik());
        temp.setEmail(customer.getEmail());
        temp.setPassword(encodeMD5.getSecurePassword(customer.getPassword()));

        Query query = entityManager.createQuery("FROM CustomerEntity order by customerNumber desc");
        query.setMaxResults(1);

        if (query.getResultList().isEmpty()) {
            temp.setCustomerNumber("CS-001");
        }else {
            CustomerEntity cust = (CustomerEntity) query.getSingleResult();
            Autogenerateid customerNumber = new Autogenerateid("CS-", cust.getCustomerNumber(), "0", 2);
            temp.setCustomerNumber(customerNumber.generatedid());
        }
        return customerRepository.save(temp);
    }

    @Transactional
    @Override
    public CustomerEntity update(CustomerEntity customer) {
        CustomerEntity data = entityManager.merge(customer);
        return data;
    }

    @Transactional
    @Override
    public CustomerEntity delete(CustomerEntity customer) {
        entityManager.remove(customer);
        return customer;
    }

    @Override
    public CustomerEntity login(CustomerEntity customer) throws NotFoundException {
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
