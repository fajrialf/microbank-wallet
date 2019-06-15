package com.enigma.walletkurs.repository;

import com.enigma.walletkurs.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
    CustomerEntity findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNik(String nik);
}
