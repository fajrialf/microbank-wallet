package com.enigma.walletkurs;

import com.enigma.walletkurs.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BeanConfig.class})
@EntityScan({"com.enigma.walletkurs.models","com.enigma.walletkurs"})
public class WalletKursApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletKursApplication.class, args);
	}

}
