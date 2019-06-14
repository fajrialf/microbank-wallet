package com.enigma.walletkurs.config;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.dao.TransactionTypeDao;
import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.daoimpl.AccountDaoImplement;
import com.enigma.walletkurs.daoimpl.AccountTypeDaoImpl;
import com.enigma.walletkurs.daoimpl.CustomerDaoImplement;
import com.enigma.walletkurs.daoimpl.TransactionDaoImplement;
import com.enigma.walletkurs.daoimpl.TransactionTypeDaoImpl;
import com.enigma.walletkurs.daoimpl.WalletDaoImplement;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class BeanConfig {

    @Bean
    public CustomerDao customerDao(){
        return new CustomerDaoImplement();
    }
    
    @Bean
    public AccountDao accountDao() {
    	return new AccountDaoImplement();
    }
    
    @Bean
    public WalletDao walletDao() {
    	return new WalletDaoImplement();
    }
    
    @Bean
    public AccountTypeDao accountTypeDao() {
    	return new AccountTypeDaoImpl();
    }
    
    @Bean
    public TransactionTypeDao transactionTypeDao() {
    	return new TransactionTypeDaoImpl();
    }
    
    @Bean
    public TransactionDao transactionDao() { return new TransactionDaoImplement(); }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD","GET","PUT","POST","DELETE","PATCH");
            }
        };
    }
}
