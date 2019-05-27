package com.enigma.walletkurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.walletkurs.models.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

}
