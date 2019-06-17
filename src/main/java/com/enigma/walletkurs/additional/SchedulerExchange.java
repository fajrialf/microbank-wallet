package com.enigma.walletkurs.additional;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.models.ExchangeEntity;
import com.enigma.walletkurs.models.OutStandingEntity;

@Component
public class SchedulerExchange {

	@Autowired
	ExchangeDao excdao;
	
//    @Scheduled(fixedRate=5000)
//    public void inputexchange() {
//    	ExchangeEntity exchange= new ExchangeEntity();
//    	exchange.setBuy(0.0);
//    	exchange.setSell(0.0);
//    	exchange.setDate(new Date());
//    	exchange.setcCy1("IDR");
//    	exchange.setcCy2("USD");
//    	excdao.createentity(exchange);
//    }
//    
//    @Scheduled(cron="59 59 23 * * ?")
//    public void outstanding() {
//    	OutStandingEntity tempout =new OutStandingEntity();
//    }
}
