package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;

public interface CustomerDao {
    CustomerEntity getByCustomerNumber(String account);
    CustomerEntity create(CustomerEntity customer);
    CustomerEntity update(CustomerEntity customer);
    CustomerEntity delete(CustomerEntity customer);
    CustomerEntity login(CustomerEntity customer) throws NotFoundException;
}
