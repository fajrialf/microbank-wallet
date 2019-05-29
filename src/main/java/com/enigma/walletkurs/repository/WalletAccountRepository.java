package com.enigma.walletkurs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.walletkurs.models.WalletAccountEntity;

public interface WalletAccountRepository extends JpaRepository<WalletAccountEntity, Integer> {
	List<WalletAccountEntity>findByWalletIdWalletId(String walletid);
	List<WalletAccountEntity>findByWalletIdWalletIdAndStatus(String walletid,String status);
}
