package com.enigma.walletkurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.ExchangeEntity;

@RestController
public class ExchangeContoller {


    @Autowired
    ExchangeDao exchangeDao;
    
    @GetMapping(value="exchanges")
    public CommonResponse<List<ExchangeEntity>>getallexchange(){
    	CommonResponse<List<ExchangeEntity>>resp= new CommonResponse<>();
    	resp.setData(exchangeDao.listRate());
    	return resp;
    }
}
