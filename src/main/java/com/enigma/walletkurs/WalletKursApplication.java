package com.enigma.walletkurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan("com.enigma.walletkurs.models")
public class WalletKursApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletKursApplication.class, args);
	}

}

