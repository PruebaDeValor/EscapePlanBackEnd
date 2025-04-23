package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "person_sessions")
public class PersonSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Session session;

    // Valoración de la experiencia de 0 a 5, en pasos de 0.5 (sin validación estricta)
    @Min(0)
    @Max(5)
    private Double rating;

    // Constructor vacío requerido por JPA
    public PersonSession() {
    }

    // Constructor con todos los parámetros
    public PersonSession(Person person, Session session, Double rating) {
        this.person = person;
        this.session = session;
        this.rating = rating;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
