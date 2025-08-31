package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrubadevalorEscapesApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(PrubadevalorEscapesApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
	System.out.println("La aplicación se ha iniciado correctamente.");
    }

}
