package com.enigma.walletkurs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.AccountTypeDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.dao.ExchangeDao;
import com.enigma.walletkurs.dao.OutstandingDao;
import com.enigma.walletkurs.dao.TradingDao;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.dao.TransactionTypeDao;
import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.daoimpl.AccountDaoImplement;
import com.enigma.walletkurs.daoimpl.AccountTypeDaoImpl;
import com.enigma.walletkurs.daoimpl.CustomerDaoImplement;
import com.enigma.walletkurs.daoimpl.ExchangeDaoImpl;
import com.enigma.walletkurs.daoimpl.OutStandingDaoImpl;
import com.enigma.walletkurs.daoimpl.TradingDaoImpl;
import com.enigma.walletkurs.daoimpl.TransactionDaoImplement;
import com.enigma.walletkurs.daoimpl.TransactionTypeDaoImpl;
import com.enigma.walletkurs.daoimpl.WalletDaoImplement;

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
    public ExchangeDao exchangeDao() {
    	return new ExchangeDaoImpl();
    }
    
    @Bean
    public TradingDao tradeDao() {
    	return new TradingDaoImpl();
    }
    
    @Bean
    public OutstandingDao outstandingDao() {
    	return new OutStandingDaoImpl();		
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
