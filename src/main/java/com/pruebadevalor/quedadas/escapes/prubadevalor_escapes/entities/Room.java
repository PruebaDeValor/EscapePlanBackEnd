package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name; //nombre de la escape   

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description; //descripción de la escape    

    @Size(max=50, message = "City cannot be longer than 50 characters")
    private String city; //ciudad donde está la escape

    @NotNull(message = "Province cannot be null")
    @Min(value = 0, message = "Province must be a valid number (0 for other countries, 1-52 for Spain)") // Validación para el rango
    private Integer province;  // Código de la provincia (numeral) o 0 para otro país

    //Faltan nº de personas min y max, duración,  empresa, idioma, temática, url, dirección, 
}
