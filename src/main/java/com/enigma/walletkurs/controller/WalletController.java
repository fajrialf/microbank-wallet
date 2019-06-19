package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.WalletAccountDto;
import com.enigma.walletkurs.models.dto.WalletDto;

@RestController
public class WalletController {

	
	@Autowired
	private WalletDao walletdao;
	
	private static final String URI_REQUEST_WALLET="wallet";

	private  static final String URI_REQUEST_WALLETACC="walletaccount";
	
	@PostMapping(path = URI_REQUEST_WALLET)
	public CommonResponse<WalletEntity>createwallet(@RequestBody WalletDto wallet) throws ExistException{
		CommonResponse<WalletEntity>resp=new CommonResponse<>();
		resp.setData(walletdao.createwallet(wallet));
		return resp;
	}
	
	@PostMapping(path=URI_REQUEST_WALLETACC)
	public CommonResponse<WalletAccountEntity>registerwallet(@RequestBody WalletAccountDto walletacc) throws ExistException{
		CommonResponse<WalletAccountEntity>resp= new CommonResponse<>();
		resp.setData(walletdao.registeraccount(walletacc));
		return resp;
	}
	
	@GetMapping(path=URI_REQUEST_WALLET+"/{id}/account")
	public CommonResponse<List<WalletAccountEntity>>getallwalletaccount(@PathVariable(name="id") String id){
		CommonResponse<List<WalletAccountEntity>>resp= new CommonResponse<>();
		resp.setData(walletdao.getAllWalletAccountByWallet(id));
		return resp;		
	}
}
