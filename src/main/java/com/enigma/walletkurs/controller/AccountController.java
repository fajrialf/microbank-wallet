package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.dto.AccountDto;

@RestController
public class AccountController {

	public static final String URI_REQUEST_ACCOUNT = "account";
    public static final String URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER = "account/{accountNumber}";
    public static final String URI_REQUEST_ACCOUNTS_BY_CUSTOMER_NUMBER = "accounts/{customerNumber}";

    @Autowired
    private AccountDao accountDao;

    String accexceptionmsg="Account ID %s not found";
    @PostMapping(value = URI_REQUEST_ACCOUNT)
    public CommonResponse<AccountEntity> add(@RequestBody AccountDto account) throws ExistException {
        CommonResponse<AccountEntity> acc = new CommonResponse<>();
        AccountEntity tempAcc = accountDao.create(account);
        acc.setData(tempAcc);
        return acc;
    }

    @PutMapping(value = URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER)
    public CommonResponse<AccountEntity> update(@RequestBody AccountDto account) throws NotFoundException {
        AccountEntity acc = accountDao.getByAccountNumber(account.getAccountNumber());
        CommonResponse<AccountEntity> response = new CommonResponse<>();
        if (acc == null) {
            throw new NotFoundException(44, "Customer data doesn't exist!");
        } else {
            response.setData(accountDao.update(account));
        }
        return response;
    }

    @GetMapping(value = URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER)
    public CommonResponse<AccountEntity> getByAccount(@PathVariable(name = "accountNumber") String accountNumber) throws NotFoundException {
        AccountEntity account = accountDao.getByAccountNumber(accountNumber);
        CommonResponse<AccountEntity> response = new CommonResponse<>();
        if (account == null) {
            throw new NotFoundException(44, String.format(accexceptionmsg, accountNumber));
        } else {
            response.setData(account);
        }
        return response;
    }

    @GetMapping(value = URI_REQUEST_ACCOUNTS_BY_CUSTOMER_NUMBER)
    public CommonResponse<List<AccountEntity>> getAccountsByCif(
            @PathVariable(name = "customerNumber") String customerNumber) throws EntityNotFoundException {
        List<AccountEntity> listAccount = accountDao.getAccountsByCustomerNumber(customerNumber);
        CommonResponse<List<AccountEntity>> resp = new CommonResponse<>();
        if (listAccount == null) {
            throw new EntityNotFoundException(44, String.format(accexceptionmsg, customerNumber));
        } else {
            resp.setData(listAccount);
        }
        return resp;
    }

    @DeleteMapping(value = URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER)
    public CommonResponse<AccountEntity> deleteAccount(@PathVariable(name = "accountNumber") String accountNumber) throws NotFoundException {
        AccountEntity check = accountDao.getByAccountNumber(accountNumber);
        CommonResponse<AccountEntity> resp = new CommonResponse<>();
        if (check == null) {
            throw new NotFoundException(44, String.format(accexceptionmsg, accountNumber));
        } else {
            resp.setData(accountDao.delete(check));
        }
        return resp;
    }
}