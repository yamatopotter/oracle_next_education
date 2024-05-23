package com.matheus.fipe;

import com.matheus.fipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}

	public void run(String... args) throws Exception{
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}
