package com.enigma.walletkurs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.walletkurs.models.TradingEntity;

public interface TradingRepository extends JpaRepository<TradingEntity, String> {

	List<TradingEntity>findByTradingId(String id);
}
