package com.enigma.walletkurs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.walletkurs.models.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
	List<AccountEntity> findByCustomerNumberCustomerNumber(String custnum);
	boolean existsByAccountTypeDescriptionAndCustomerNumberCustomerNumber(String description,String cusnum);
	AccountEntity findByCustomerNumberCustomerNumberAndAccountTypeDescription(String accnum,String acctype);
}
