package com.enigma.walletkurs.dao;

import java.util.List;

import com.enigma.walletkurs.models.ExchangeEntity;

public interface ExchangeDao {
	ExchangeEntity createentity(ExchangeEntity exchange);
	List<ExchangeEntity>listRate();
}
