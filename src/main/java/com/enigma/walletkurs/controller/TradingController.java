package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.dao.TradingDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.dto.TradingDto;

@RestController
public class TradingController {
	public static final String URI_REQUEST_TRADING = "trading";
	public static final String URI_REQUEST_TRADINGS = "tradings";

    @Autowired
    TradingDao tradedao;
    
    @Autowired
    ExchangeDao exchangeDao;
    
    @PostMapping(value=URI_REQUEST_TRADING)
    public CommonResponse<TradingEntity> trading(@RequestBody TradingDto trade) throws EntityNotFoundException, InsufficientAmountException{
    	CommonResponse<TradingEntity>resp= new CommonResponse<>();
    	if (trade.getType().equalsIgnoreCase("s")) {
    	resp.setData(tradedao.sellAsset(trade));}
    	else {
        	resp.setData(tradedao.buyAsset(trade));
    	}
    	return resp;
    }
    
    @GetMapping(value=URI_REQUEST_TRADINGS)
    public CommonResponse<List<TradingEntity>>listtrading(){
    	CommonResponse<List<TradingEntity>>resp=new CommonResponse<>();
    	resp.setData(tradedao.getalltrading());
    	return resp;
    }
    
    @GetMapping(value=URI_REQUEST_TRADINGS+"/{id}/balance")
    public CommonResponse<Double>balancetrading(@PathVariable(name="id")String id){
    	CommonResponse<Double>resp=new CommonResponse<>();
    	resp.setData(tradedao.totalBalance(id));
    	return resp;
    }
    
    @GetMapping(value=URI_REQUEST_TRADINGS+"/{id}")
    public CommonResponse<List<TradingEntity>>Historytrading(@PathVariable(name="id")String id){
    	CommonResponse<List<TradingEntity>>resp=new CommonResponse<>();
    	resp.setData(tradedao.historytrading(id));
    	return resp;
    }
}
