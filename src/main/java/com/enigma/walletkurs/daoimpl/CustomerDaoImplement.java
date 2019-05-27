package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.models.CustomerEntity;
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
    public CustomerEntity create(CustomerEntity customer) {
        CustomerEntity data = entityManager.merge(customer);
        return data;
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
    public CustomerEntity login(CustomerEntity customer) throws UserException {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            CustomerEntity user = customerRepository.findByEmail(customer.getEmail());
            if (customer.getPassword().equals(user.getPassword())) {
                return user;
            } else {
                throw new UserException(44, "Wrong Email Or Password!");
            }
        } else {
            throw new UserException(44, "Wrong Email Or Password!");
        }
    }
}
