package com.enigma.walletkurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.walletkurs.models.ExchangeEntity;

public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Integer> {

}
