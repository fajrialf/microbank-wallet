package com.enigma.walletkurs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.walletkurs.models.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity, String> {
	boolean existsByDescription(String desc);
	List<WalletEntity>findBycustomerNumberCustomerNumberAndStatus(String cusnum,String status);
	WalletEntity findByWalletIdAndStatus(String id,String status);
	WalletEntity findByDescription(String desc);
}
