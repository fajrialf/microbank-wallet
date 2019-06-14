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

	Double amount;
	
	Double income;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
	
	
}
