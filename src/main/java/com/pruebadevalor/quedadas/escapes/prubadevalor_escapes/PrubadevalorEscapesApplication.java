package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@SpringBootApplication
public class PrubadevalorEscapesApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	/*@Autowired
	private PersonGroupRepository personGroupRepository;

	@Autowired
	private EscapeGroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(PrubadevalorEscapesApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
	System.out.println("La aplicación se ha iniciado correctamente.");
    }

}
