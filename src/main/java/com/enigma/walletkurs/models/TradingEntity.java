package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_trading")
public class TradingEntity {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trading_id")
	String tradingId;
	
	@Column(name="date")
	Date date;
	
	@Column(name="ccy")
	String ccy;
	
	@Column(name="type")
	String type;
	
	@OneToOne
	@JoinColumn(name="rate_id")
	ExchangeEntity rateId;
	
	public void setRateId(ExchangeEntity rateId) {
		this.rateId = rateId;
	}

	@Column(name="amount")
	Float amount;
	
	@Column(name="income")
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


	public ExchangeEntity getRateId() {
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
