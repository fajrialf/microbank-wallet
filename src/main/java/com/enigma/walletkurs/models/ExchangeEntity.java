package com.enigma.walletkurs.models;

import java.util.Date;

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
	
	@Column(name="ccy1")
	String cCy1;
	
	@Column(name="ccy2")
	String cCy2;
	
	@Column(name="date")
	Date date;
	
	@Column(name="buy")
	Double buy;
	
	@Column(name="sell")
	Double sell;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public String getcCy1() {
		return cCy1;
	}

	public void setcCy1(String cCy1) {
		this.cCy1 = cCy1;
	}

	public String getcCy2() {
		return cCy2;
	}

	public void setcCy2(String cCy2) {
		this.cCy2 = cCy2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getBuy() {
		return buy;
	}

	public void setBuy(Double buy) {
		this.buy = buy;
	}

	public Double getSell() {
		return sell;
	}

	public void setSell(Double sell) {
		this.sell = sell;
	}
}
