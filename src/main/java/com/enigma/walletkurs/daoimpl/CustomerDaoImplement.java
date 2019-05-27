package com.enigma.walletkurs.daoimpl;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.models.CustomerEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDaoImplement implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public CustomerEntity getByCustomerNumber(String customerNumber) {
        return entityManager.find(CustomerEntity.class, customerNumber);
    }

    @Override
    public CustomerEntity create(CustomerEntity customer) {
        return null;
    }

    @Override
    public CustomerEntity update(CustomerEntity customer) {
        return null;
    }

    @Override
    public CustomerEntity delete(CustomerEntity customer) {
        return null;
    }
}
