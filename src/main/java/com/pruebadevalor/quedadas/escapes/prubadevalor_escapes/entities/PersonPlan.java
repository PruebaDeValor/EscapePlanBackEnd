package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "person_plans")
public class PersonPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Person person; // Persona asociada al plan

    @ManyToOne(optional = false)
    private Plan plan; // Plan asociado a la persona

    // Constructor vacío requerido por JPA
    public PersonPlan() {
    }
    // Constructor con todos los parámetros
    public PersonPlan(Person person, Plan plan) {
        this.person = person;
        this.plan = plan;
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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
