package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.dao.TradingDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.ExchangeEntity;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.dto.TradingDto;

@RestController
public class TradingController {
	public static final String URI_REQUEST_Trading = "trading";

    @Autowired
    TradingDao tradedao;
    
    @Autowired
    ExchangeDao exchangeDao;
    
    @PostMapping(value=URI_REQUEST_Trading)
    public CommonResponse<TradingEntity> trading(@RequestBody TradingDto trade) throws EntityNotFoundException, InsufficientAmountException{
    	CommonResponse<TradingEntity>resp= new CommonResponse<>();
    	if (trade.getType().equalsIgnoreCase("s")) {
    	resp.setData(tradedao.sellAsset(trade));}
    	else {
        	resp.setData(tradedao.buyAsset(trade));
    	}
    	return resp;
    }
    
    @GetMapping
    public CommonResponse<List<ExchangeEntity>>getallexchange(){
    	CommonResponse<List<ExchangeEntity>>resp= new CommonResponse<>();
    	resp.setData(exchangeDao.listRate());
    	return resp;
    }
}
