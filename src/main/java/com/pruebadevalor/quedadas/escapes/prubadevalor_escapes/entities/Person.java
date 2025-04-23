package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name cannot be empty")
    @Size(max = 100, message = "First name cannot be longer than 100 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(max = 100, message = "Last name cannot be longer than 100 characters")
    private String lastName;

    private LocalDate birthDate; // Fecha de nacimiento

    private Integer numEscapes; // Número total de escapes

    private Integer numEscapesOrganized; // Número de escapes organizadas por la persona

    private Integer numPlans; // Número total de planes

    private Integer numPlansOrganized; // Número de planes organizados por la persona

    private LocalDate registrationDate; // Fecha de registro en la aplicación

    @OneToMany(mappedBy = "person")
    private List<PersonGroup> personGroups; // Relación de la persona con sus grupos

    @OneToMany(mappedBy = "person")
    private List<PersonSession> personSessions; // Relación de la persona con sus sesiones

    @ManyToMany(mappedBy = "members")
    private List<Group> groups; // Grupos a los que pertenece la persona (relación bidireccional)

    private boolean isPremium; // Indica si la persona es premium o no
    

    // Constructor vacío requerido por JPA
    public Person() {
    }

    // Constructor con parámetros
    public Person(String firstName, String lastName, LocalDate birthDate, Integer numEscapes,
                  Integer numEscapesOrganized, Integer numPlans, Integer numPlansOrganized,
                  LocalDate registrationDate, boolean isPremium) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.numEscapes = numEscapes;
        this.numEscapesOrganized = numEscapesOrganized;
        this.numPlans = numPlans;
        this.numPlansOrganized = numPlansOrganized;
        this.registrationDate = registrationDate;
        this.isPremium = isPremium;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getNumEscapes() {
        return numEscapes;
    }

    public void setNumEscapes(Integer numEscapes) {
        this.numEscapes = numEscapes;
    }

    public Integer getNumEscapesOrganized() {
        return numEscapesOrganized;
    }

    public void setNumEscapesOrganized(Integer numEscapesOrganized) {
        this.numEscapesOrganized = numEscapesOrganized;
    }

    public Integer getNumPlans() {
        return numPlans;
    }

    public void setNumPlans(Integer numPlans) {
        this.numPlans = numPlans;
    }

    public Integer getNumPlansOrganized() {
        return numPlansOrganized;
    }

    public void setNumPlansOrganized(Integer numPlansOrganized) {
        this.numPlansOrganized = numPlansOrganized;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<PersonGroup> getPersonGroups() {
        return personGroups;
    }

    public void setPersonGroups(List<PersonGroup> personGroups) {
        this.personGroups = personGroups;
    }

    public List<PersonSession> getPersonSessions() {
        return personSessions;
    }

    public void setPersonSessions(List<PersonSession> personSessions) {
        this.personSessions = personSessions;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", numEscapes=" + numEscapes +
                ", numEscapesOrganized=" + numEscapesOrganized +
                ", numPlans=" + numPlans +
                ", numPlansOrganized=" + numPlansOrganized +
                ", registrationDate=" + registrationDate +
                ", isPremium=" + isPremium +
                '}';
    }
}
