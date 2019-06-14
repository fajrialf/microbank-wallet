package com.enigma.walletkurs.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	public Double getSisa() {
		return sisa;
	}

	public void setSisa(Double sisa) {
		this.sisa = sisa;
	}

	@Column(name="date")
	Date date;
	
	@Column(name="ccy")
	String ccy;
	
	@Column(name="type")
	String type;
	
	@OneToOne
	@JoinColumn(name="rate_id")
	ExchangeEntity rateId;
	
	
	@Column(name="sisa")
	Double sisa;
	
	
	public void setRateId(ExchangeEntity rateId) {
		this.rateId = rateId;
	}

	@Column(name="amount")
	Double amount;
	
	@Column(name="income")
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


	public ExchangeEntity getRateId() {
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
