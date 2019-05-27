package com.enigma.walletkurs.controller;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    public static final String URI_REQUEST_CUSTOMER = "customer";
    private static final String URI_REQUEST_CUSTOMER_BY_CUSTOMER_NUMBER = "customer/{customerNumber}";
    private static final String URI_REQUEST_CUSTOMER_LOGIN = "customer/login";

    @Autowired
    private CustomerDao customerDao;

    @PostMapping(value = URI_REQUEST_CUSTOMER)
    public CommonResponse<CustomerEntity> create(@RequestBody CustomerEntity customer) {
        CommonResponse<CustomerEntity> data = new CommonResponse<>();
        CustomerEntity newCustomer = customerDao.create(customer);
        data.setData(newCustomer);
        return data;
    }

    @GetMapping(value = URI_REQUEST_CUSTOMER_BY_CUSTOMER_NUMBER)
    public CommonResponse<CustomerEntity> getStudentById(@PathVariable(name = "customerNumber") String customerNumber) throws NotFoundException {
        CustomerEntity customer = customerDao.getByCustomerNumber(customerNumber);
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        if (customer == null) {
            throw new NotFoundException(44, String.format("Customer ID %d not found", customerNumber));
        } else {
            response.setData(customer);
        }
        return response;
    }

    @PutMapping(value = URI_REQUEST_CUSTOMER_BY_CUSTOMER_NUMBER)
    public CommonResponse<CustomerEntity> update(@RequestBody CustomerEntity customer) throws NotFoundException {
        CustomerEntity data = customerDao.getByCustomerNumber(customer.getCustomerNumber());
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        if (data == null) {
            throw new NotFoundException(44, "Customer data doesn't exist!");
        } else {
            customerDao.update(customer);
            response.setData(customer);
        }
        return response;
    }

    @DeleteMapping(value = URI_REQUEST_CUSTOMER_BY_CUSTOMER_NUMBER)
    public CommonResponse<CustomerEntity> delete(@PathVariable(name = "customerNumber") String customerNumber) throws NotFoundException {
        CustomerEntity customer = customerDao.getByCustomerNumber(customerNumber);
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        if (customer == null) {
            throw new NotFoundException(44, String.format("Customer ID %d not found", customerNumber));
        } else {
            response.setData(customerDao.delete(customer));
        }
        return response;
    }

    @PostMapping(path = URI_REQUEST_CUSTOMER_LOGIN)
    public CommonResponse<CustomerEntity> login(@RequestBody CustomerEntity customer)  {
        CustomerEntity std = customerDao.login(customer);
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        response.setData(std);
        return response;
    }
}
