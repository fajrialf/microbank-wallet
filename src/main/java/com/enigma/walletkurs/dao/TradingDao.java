package com.enigma.walletkurs.dao;

import java.util.List;

import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.dto.TradingDto;

public interface TradingDao {

	TradingEntity buyAsset(TradingDto trade) throws InsufficientAmountException, EntityNotFoundException;
	TradingEntity sellAsset(TradingDto trade) throws EntityNotFoundException, InsufficientAmountException;
	Double totalBalance(String tradeid);
	List<TradingEntity>getalltrading();
}
