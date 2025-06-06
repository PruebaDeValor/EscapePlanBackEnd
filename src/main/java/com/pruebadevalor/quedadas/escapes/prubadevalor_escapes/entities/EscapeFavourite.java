package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "escape_favourites")
public class EscapeFavourite {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id; // Identificador único de la entrada de favoritos

    @NotBlank(message = "Room cannot be empty")
    private Room room;

    @NotBlank(message = "Person cannot be empty")
    private Person person; // Persona que ha marcado el escape como favorito
    // Constructor vacío requerido por JPA
    public EscapeFavourite() {
    }

    // Constructor con todos los parámetros
    public EscapeFavourite(Room room, Person person) {
        this.room = room;
        this.person = person;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    


}
