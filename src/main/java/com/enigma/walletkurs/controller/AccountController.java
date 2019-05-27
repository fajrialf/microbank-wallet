package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.AccountEntity;

@RestController
public class AccountController {

	public static final String URI_REQUEST_ACCOUNTS = "/account";
	public static final String URI_REQUEST_ACCOUNT_BY_ID = "/account/{accountNumber}";

	@Autowired
	private AccountDao accountDao;

	@GetMapping(value = URI_REQUEST_ACCOUNT_BY_ID)
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
}