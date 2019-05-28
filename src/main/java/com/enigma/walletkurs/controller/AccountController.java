package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;

@RestController
public class AccountController {

	public static final String URI_REQUEST_ACCOUNT = "account";
	public static final String URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER = "/account/{accountNumber}";
	public static final String URL_REQUEST_ACCOUNTS_BY_CIF = "/accountcif/{customerNumber}";

	@Autowired
	private AccountDao accountDao;

	@PostMapping(value = URI_REQUEST_ACCOUNT)
	public CommonResponse<AccountEntity> add(@RequestBody AccountEntity account) {
		CommonResponse<AccountEntity> acc = new CommonResponse<>();
		AccountEntity tempAcc = accountDao.addAccount(account);
		acc.setData(tempAcc);
		return acc;
	}

	@PutMapping(value = URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER)
	public CommonResponse<AccountEntity> update(@RequestBody AccountEntity account) throws NotFoundException {
		AccountEntity acc = accountDao.getByAccountNumber(account.getAccountNumber());
		CommonResponse<AccountEntity> response = new CommonResponse<>();
		if (acc == null) {
			throw new NotFoundException(44, "Customer data doesn't exist!");
		} else {
			accountDao.updateAccount(account);
			response.setData(account);
		}
		return response;
	}

	@GetMapping(value = URI_REQUEST_ACCOUNT_BY_ACCOUNT_NUMBER)
	public CommonResponse<AccountEntity> getByAccount(@PathVariable(name = "accountNumber") String accountNumber)
			throws EntityNotFoundException {
		AccountEntity account = accountDao.getByAccountNumber(accountNumber);
		CommonResponse<AccountEntity> response = new CommonResponse<>();
		if (account == null) {
			throw new EntityNotFoundException("44", String.format("Student ID %d not found", accountNumber));
		} else {
			response.setData(account);
		}
		return response;
	}

	@GetMapping(value = URL_REQUEST_ACCOUNTS_BY_CIF)
	public CommonResponse<List<AccountEntity>> getAccountsByCif(
			@PathVariable(name = "customerNumber") CustomerEntity customerNumber) throws EntityNotFoundException {
		List<AccountEntity> listAccount = accountDao.getAccountsByCIF(customerNumber);
		CommonResponse<List<AccountEntity>> resp = new CommonResponse<>();
		if (listAccount == null) {
			throw new EntityNotFoundException("44", String.format("Student ID %d not found", customerNumber));
		} else {
			resp.setData(listAccount);
		}
		return resp;
	}
}