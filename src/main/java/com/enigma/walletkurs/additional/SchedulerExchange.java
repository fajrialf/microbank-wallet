package com.enigma.walletkurs.additional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.models.ExchangeEntity;
import com.enigma.walletkurs.models.OutStandingEntity;
import com.enigma.walletkurs.models.dto.KursDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SchedulerExchange {

	@Autowired
	ExchangeDao excdao;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final TypeReference<KursDto> TYPE_COMMON_RESP_CUSTOMERS = new TypeReference<KursDto>() {}; 
	
    @Scheduled(fixedDelay=3000)
    public void inputexchange() throws JsonParseException, JsonMappingException, IOException, ParseException {
    	KursDto newkurs= new KursDto();
		RestTemplate restTemplate = new RestTemplate();
		String getKursUrl = String.format("https://kurs.web.id/api/v1/bi");//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum

		ResponseEntity<String> response = restTemplate.getForEntity(getKursUrl, String.class);
		
		if(response.getStatusCode()!=HttpStatus.OK) {
			System.out.println(String.format("error %s", response.getStatusCodeValue()));
		} else if(StringUtils.isEmpty(response.getBody())) {
			System.out.println("response null");
		} else {
			//contoh untuk GET dengan langsung menerima response body dalam bentuk POJO (tidak perlu menggunakan ObjectMapper lagi)
			KursDto respBody = MAPPER.readValue(response.getBody(), TYPE_COMMON_RESP_CUSTOMERS);
			if(respBody.getError().equalsIgnoreCase("true")) {
				System.out.println("failed get api");
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
    
//    @Scheduled(cron="59 59 23 * * ?")
//    public void outstanding() {
//    	OutStandingEntity tempout =new OutStandingEntity();
//    }
}
