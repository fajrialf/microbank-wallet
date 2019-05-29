package com.enigma.walletkurs.models.dto;

public class ExchangeDto {

	int rateId;
	
	Float buy;
	
	Float sell;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public Float getBuy() {
		return buy;
	}

	public void setBuy(Float buy) {
		this.buy = buy;
	}

	public Float getSell() {
		return sell;
	}

	public void setSell(Float sell) {
		this.sell = sell;
	}
	
	
}
