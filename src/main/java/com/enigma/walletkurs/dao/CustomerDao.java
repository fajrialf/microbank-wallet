package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.LoginDto;

public interface CustomerDao {
    CustomerEntity getByCustomerNumber(String account);
    CustomerEntity create(CustomerDto customer);
    CustomerEntity update(CustomerDto customer);
    CustomerEntity delete(CustomerEntity customer);
    CustomerEntity login(LoginDto customer) throws NotFoundException;
}
