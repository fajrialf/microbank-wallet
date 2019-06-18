package com.enigma.walletkurs.additional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.dao.OutstandingDao;
import com.enigma.walletkurs.dao.TradingDao;
import com.enigma.walletkurs.exception.HandlerException;
import com.enigma.walletkurs.models.ExchangeEntity;
import com.enigma.walletkurs.models.OutStandingEntity;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.dto.KursDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SchedulerExchange {

	@Autowired
	ExchangeDao excdao;
	
	@Autowired
	CustomerDao cusdao;
	
	@Autowired
	OutstandingDao outstandingDao;
	
	@Autowired
	TradingDao tradingDao;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final TypeReference<KursDto> TYPE_COMMON_RESP_CUSTOMERS = new TypeReference<KursDto>() {}; 
	private static final Logger LOGGER = LoggerFactory.getLogger(HandlerException.class);
    @Scheduled(fixedDelay=3000)
    public void inputexchange() throws IOException, ParseException{
    	KursDto newkurs= new KursDto();
		RestTemplate restTemplate = new RestTemplate();
		String getKursUrl = "https://kurs.web.id/api/v1/bi";//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum

		ResponseEntity<String> response = restTemplate.getForEntity(getKursUrl, String.class);
		
		if(response.getStatusCode()!=HttpStatus.OK) {
			String msg=String.format("error %s", response.getStatusCodeValue());
			LOGGER.debug(msg);
		} else if(StringUtils.isEmpty(response.getBody())) {
			LOGGER.debug("response null");
		} else {
			//contoh untuk GET dengan langsung menerima response body dalam bentuk POJO (tidak perlu menggunakan ObjectMapper lagi)
			KursDto respBody = MAPPER.readValue(response.getBody(), TYPE_COMMON_RESP_CUSTOMERS);
			if(respBody.getError().equalsIgnoreCase("true")) {
				LOGGER.debug("failed get api");
			}else {
				newkurs = respBody;
			}
		}
    	ExchangeEntity exchange= new ExchangeEntity();
    	exchange.setBuy(Double.parseDouble(newkurs.getBeli()));
    	exchange.setSell(Double.parseDouble(newkurs.getJual()));
    	SimpleDateFormat kursdate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	exchange.setDate(kursdate.parse(newkurs.getTimestamp()));
    	exchange.setcCy1("IDR");
    	exchange.setcCy2(newkurs.getMatauang());
    	excdao.createentity(exchange);
    }
    
//    @Scheduled(fixedDelay=3000)
//    public void outstanding() {
//    	List<TradingEntity>templist=tradingDao.getalltrading();
//    	if (!templist.isEmpty()) {
//        	for (TradingEntity tradingEntity : templist) {
//        		Double tempbalance=tradingDao.totalBalance(tradingEntity.getTradingId());
//            	OutStandingEntity tempout =new OutStandingEntity();	
//            	tempout.setDate(new Date());
//            	tempout.setOutstanding(tempbalance);
//            	tempout.setTrader(tradingEntity);
//            	outstandingDao.createoutstanding(tempout);
//    		}
//    	}
//    }
}
