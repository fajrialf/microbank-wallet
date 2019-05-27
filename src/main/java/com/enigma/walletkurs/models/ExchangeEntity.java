package com.enigma.walletkurs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_exchange")
public class ExchangeEntity {

	@Id
	@Column(name="rate_id")
	String rateId;
	
	@Column(name="buy")
	String buy;
	
	@Column(name="sell")
	String sell;
	
	
}
