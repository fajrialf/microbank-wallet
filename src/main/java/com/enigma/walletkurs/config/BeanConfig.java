package com.enigma.walletkurs.config;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.CustomerDao;
import com.enigma.walletkurs.daoimpl.AccountDaoImplement;
import com.enigma.walletkurs.daoimpl.CustomerDaoImplement;
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
