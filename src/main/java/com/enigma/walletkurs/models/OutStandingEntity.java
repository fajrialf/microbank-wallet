package com.enigma.walletkurs.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_outstanding")
public class OutStandingEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="date")
	Date date;

	@OneToOne
	@JoinColumn(name="trader_Id")
	TradingEntity trader;
	
	
	@Column(name="outstanding")
	Double outstanding;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public TradingEntity getTrader() {
		return trader;
	}


	public void setTrader(TradingEntity trader) {
		this.trader = trader;
	}


	public Double getOutstanding() {
		return outstanding;
	}


	public void setOutstanding(Double outstanding) {
		this.outstanding = outstanding;
	}
}
