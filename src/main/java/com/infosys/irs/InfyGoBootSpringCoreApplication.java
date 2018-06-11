package com.infosys.irs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:configuration.properties" })
public class InfyGoBootSpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyGoBootSpringCoreApplication.class, args);
	}
}
