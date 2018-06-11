package com.infosys.irs;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.infosys.irs.model.User;
import com.infosys.irs.service.RegistrationService;

@SpringBootApplication
@PropertySource(value = { "classpath:configuration.properties" })
public class InfyGoBootSpringCoreApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(InfyGoBootSpringCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
			User user = new User();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter user id: ");
			user.setUserId(sc.next());
			System.out.println("Enter password: ");
			user.setPassword(sc.next());
			System.out.println("Enter name: ");
			user.setName(sc.next());
			System.out.println("Enter city: ");
			user.setCity(sc.next());
			System.out.println("Enter email: ");
			user.setEmail(sc.next());
			System.out.println("Enter phone: ");
			user.setPhone(sc.next());
			RegistrationService service = (RegistrationService) context.getBean("registrationService");
			System.out.println(environment.getProperty(service.registerUser(user)));
		} catch (Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}

}
