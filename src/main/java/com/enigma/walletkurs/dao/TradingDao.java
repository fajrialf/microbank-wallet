package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.dto.TradingDto;

public interface TradingDao {

	TradingEntity buyAsset(TradingDto trade) throws InsufficientAmountException;
	TradingEntity sellAsset(TradingDto trade) throws EntityNotFoundException, InsufficientAmountException;
	Double totalBalance(String tradeid);
}
