package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_trading")
public class TradingEntity {

	@Id
	@Column(name="trading_id")
	String tradingId;
	
	@Column(name="date")
	Date date;
	
	@Column(name="ccy")
	String ccy;
	
	@Column(name="type")
	String type;
	
	@Column(name="rate_id")
	String rateId;
	
	@Column(name="amount")
	String amount;
	
	@Column(name="income")
	String income;
	
	
}
