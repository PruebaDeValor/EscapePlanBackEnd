package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.escapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.GroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@SpringBootApplication
public class PrubadevalorEscapesApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonGroupRepository personGroupRepository;

	@Autowired
	private GroupRepository groupRepository;

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
		
		Person person = new Person("Sergio", "Martín Tejedor", LocalDate.parse("1988-07-26"), 0, 0, 0, 0,
		LocalDate.parse("2025-04-27"), true);
		personRepository.save(person);

		Person person2 = new Person("Victoria", "Paremud", LocalDate.parse("1993-10-19"), 0, 0, 0, 0,
		LocalDate.parse("2025-04-27"), true);
		personRepository.save(person2); // Guardar la segunda persona

		escapeGroup escapeGroup = new escapeGroup("Grupo de Valor", null, "Madrid", null, null, 28, 45);
		groupRepository.save(escapeGroup); // Guardar el grupo
		
		PersonGroup personGroup = new PersonGroup(
			person,
			escapeGroup,
			LocalDate.parse("2025-04-27"), // Fecha de registro
			PersonGroup.Role.ADMIN,        // Rol ADMIN del enumerado
			null,                             // Título numérico
			LocalDate.parse("2025-04-26"), // Fecha del último escape
			0,                             // Número de escapes realizados con el grupo
			0,                             // Número de escapes organizados con el grupo
			0,                             // Número de planes realizados con el grupo
			0                              // Número de planes organizados con el grupo
		);
		personGroupRepository.save(personGroup); // Guardar la relación para la primera persona

		PersonGroup personGroup2 = new PersonGroup(
			person2,
			escapeGroup,
			LocalDate.parse("2025-04-27"), // Fecha de registro
			PersonGroup.Role.MEMBER,        // Rol MEMBER del enumerado
			null,                             // Título numérico
			LocalDate.parse("2025-04-26"), // Fecha del último escape
			0,                             // Número de escapes realizados con el grupo
			0,                             // Número de escapes organizados con el grupo
			0,                             // Número de planes realizados con el grupo
			0                              // Número de planes organizados con el grupo
		);
		PersonGroup personGroupDB = personGroupRepository.save(personGroup2);
		System.out.println(personGroupDB); // Guardar la relación para la segunda persona



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
