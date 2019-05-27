package com.enigma.walletkurs.controller;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    public static final String URI_REQUEST_CUSTOMER = "customer";
    private static final String URI_REQUEST_CUSTOMER_BY_CUSTOMER_NUMBER = "customer/{customerNumber}";

    @Autowired
    private CustomerDao customerDao;

    @GetMapping(value = URI_REQUEST_CUSTOMER_BY_CUSTOMER_NUMBER)
    public CommonResponse<CustomerEntity> getStudentById(@PathVariable(name = "customerNumber") String customerNumber) throws EntityNotFoundException {
        CustomerEntity customer = customerDao.getByCustomerNumber(customerNumber);
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        if (customer == null) {
            throw new EntityNotFoundException("44", String.format("Student ID %d not found", customerNumber));
        } else {
            response.setData(customer);
        }
        return response;
    }
}
