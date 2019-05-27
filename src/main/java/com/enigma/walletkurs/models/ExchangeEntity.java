package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_exchange")
public class ExchangeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rate_id")
	int rateId;
	
	@Column(name="buy")
	Float buy;
	
	@Column(name="sell")
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
