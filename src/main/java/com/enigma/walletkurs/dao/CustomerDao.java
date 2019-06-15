package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.dto.CustomerDto;
import com.enigma.walletkurs.models.dto.LoginDto;

public interface CustomerDao {
    CustomerEntity getByCustomerNumber(String account);
    CustomerEntity create(CustomerDto customer) throws ExistException;
    CustomerEntity update(CustomerDto customer) throws ExistException;
    CustomerEntity delete(CustomerEntity customer);
    CustomerEntity login(LoginDto customer) throws NotFoundException;
}
