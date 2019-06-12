package com.enigma.walletkurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.enigma.walletkurs.config.BeanConfig;

@SpringBootApplication
@Import({BeanConfig.class})
@EntityScan({"com.enigma.walletkurs.models","com.enigma.walletkurs"})
@ComponentScan
@EnableJpaRepositories("com.enigma.walletkurs.repository")
public class WalletKursApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletKursApplication.class, args);
	}

}
