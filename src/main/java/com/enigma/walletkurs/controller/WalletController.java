package com.enigma.walletkurs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.WalletDto;

@RestController
public class WalletController {

	
	@Autowired
	private WalletDao walletdao;
	
	private final String URI_REQUEST_WALLET="wallet";

	private final String URI_REQUEST_WALLETACC="walletaccount";
	
	@PostMapping(path = URI_REQUEST_WALLET)
	public CommonResponse<WalletEntity>createwallet(@RequestBody WalletDto wallet) throws ExistException{
		CommonResponse<WalletEntity>resp=new CommonResponse<WalletEntity>();
		resp.setData(walletdao.createwallet(wallet));
		return resp;
	}
	
	@PostMapping(path=URI_REQUEST_WALLETACC)
	public CommonResponse<WalletAccountEntity>registerwallet(@RequestBody WalletAccountEntity walletacc){
		CommonResponse<WalletAccountEntity>resp= new CommonResponse<WalletAccountEntity>();
		resp.setData(walletdao.registeraccount(walletacc));
		return resp;
	}
}
