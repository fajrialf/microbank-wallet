package com.enigma.walletkurs.models.dto;

import java.sql.Date;

public class TradingDto {

	String tradingId;
	
	Date date;
	
	String ccy;
	
	String type;
	
	ExchangeDto rateId;
	
	public void setRateId(ExchangeDto rateId) {
		this.rateId = rateId;
	}

	Float amount;
	
	Float income;

	public String getTradingId() {
		return tradingId;
	}

	public void setTradingId(String tradingId) {
		this.tradingId = tradingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public ExchangeDto getRateId() {
		return rateId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getIncome() {
		return income;
	}

	public void setIncome(Float income) {
		this.income = income;
	}
	
	
}
