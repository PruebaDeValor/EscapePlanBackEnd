package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.EscapeGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@SpringBootApplication
public class PrubadevalorEscapesApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonGroupRepository personGroupRepository;

	@Autowired
	private EscapeGroupRepository groupRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrubadevalorEscapesApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
	System.out.println("La aplicación se ha iniciado correctamente.");
	manyToOne(); // Llamar al método manyToOne para crear la relación entre personas y grupos
	manyToOneFindByIdClient(); // Llamar al método manyToOneFindByIdClient para buscar una persona por su ID
	}

	@Transactional
	public void manyToOne() {
    // Persona 1
    Person person = new Person("Sergio", "Martín Tejedor", LocalDate.parse("1988-07-26"), 0, 0, 0, 0,
        LocalDate.parse("2025-04-27"), true, "semate2607@gmail.com");
    Optional<Person> existingPerson = personRepository.findByEmail(person.getEmail());
    if (existingPerson.isEmpty()) {
        personRepository.save(person);
    } else {
        person = existingPerson.get();
    }

    // Persona 2
    Person person2 = new Person("Victoria", "Paremud", LocalDate.parse("1993-10-19"), 0, 0, 0, 0,
        LocalDate.parse("2025-04-27"), true, "partoria@gmail.com");
    Optional<Person> existingPerson2 = personRepository.findByEmail(person2.getEmail());
    if (existingPerson2.isEmpty()) {
        personRepository.save(person2);
    } else {
        person2 = existingPerson2.get();
    }

    // Grupo
    EscapeGroup escapeGroup = new EscapeGroup("Grupo de Valor", null, "Madrid", null, null, 28, 45);
    groupRepository.save(escapeGroup);

    // Relación persona-grupo para la primera persona
    PersonGroup personGroup = new PersonGroup(
        person,
        escapeGroup,
        LocalDate.parse("2025-04-27"),
        PersonGroup.Role.ADMIN,
        null,
        LocalDate.parse("2025-04-26"),
        0, 0, 0, 0
    );
    personGroupRepository.save(personGroup);

    // Relación persona-grupo para la segunda persona
    PersonGroup personGroup2 = new PersonGroup(
        person2,
        escapeGroup,
        LocalDate.parse("2025-04-27"),
        PersonGroup.Role.MEMBER,
        null,
        LocalDate.parse("2025-04-26"),
        0, 0, 0, 0
    );
    PersonGroup personGroupDB = personGroupRepository.save(personGroup2);
    System.out.println(personGroupDB);
}

	@Transactional
	public void manyToOneFindByIdClient() {
		// Buscar la persona por su ID
		Long personId = 1L; // Cambia esto por el ID que quieras buscar
		Optional<Person> personOptional = personRepository.findById(personId);
		// Verificar si la persona existe
		if (personOptional.isPresent()) {
			Person person = personOptional.orElseThrow();
			System.out.println("Persona encontrada: " + person.getFirstName() + " " + person.getLastName());
		} else {
			System.out.println("Persona no encontrada.");
		}
		
	}

}
