package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;
    //nombre del usuario

    @NotBlank(message = "Surname cannot be empty")
    private String surname;
    //apellido del usuario

    @PastOrPresent
    private LocalDate registrationDate;
    //fecha de registro

    @Past
    private LocalDate birthDate;
    //fecha de nacimiento del usuario

    public enum Role {
        ADMIN,
        MODERATOR,
        MEMBER,
        CANDIDATE,
        EXTERNAL,
        EDITOR,
        AWAY,
        BANNED
    }
    //rol del usuario

    @NotNull(message = "Role cannot be null")
    private Role role;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;
    //descripción que pone la persona sobre sí mismx

    @Size(max = 50, message = "Profession cannot be longer than 50 characters")
    private String profession;
    //profesión del usuario

    @Min(value = 1, message = "Title must be at least 1")
    private Integer title;
    //número que indica el título que tiene la persona, por ejemplo novatx cuando ya es miembro pero lleva menos de 5 escape

    @PastOrPresent
    private LocalDate lastEscape;
    //Fecha en la que el usuario hizo la última escape

    @PositiveOrZero(message = "Number of escapes must be zero or positive")
    private Integer numEscapes;
    //número de escapes que ha hecho una persona

    @PositiveOrZero(message = "Number of escapes with the group must be zero or positive")
    private Integer numEscapesGroup;
    //número de escapes que ha hecho una persona con el grupo

    @PositiveOrZero(message = "Number of escapes organized must be zero or positive")
    private Integer numEscapesOrganized;
    //número de escapes que ha organizado una persona con el grupo
    
    @PositiveOrZero(message = "Number of plans must be zero or positive")
    private Integer numPlans;
    //número de planes que ha hecho con el grupo que no son escapes
    
    @PositiveOrZero(message = "Number of plans organized must be zero or positive")
    private Integer numPlansOrganized;
    //número de planes que ha organizado con el grupo.

    @PrePersist
    protected void onCreate() {
        if (this.registrationDate == null) {
            this.registrationDate = LocalDate.now(); // Asegurar que la fecha de registro no sea nula
        }
        if (this.lastEscape == null) {
            this.lastEscape = LocalDate.now(); // Asignar fecha actual si no está presente
        }
        if (this.role == null) {
            this.role = Role.CANDIDATE; // Asignar el rol predeterminado
        }
        this.title = 1; // Valor por defecto para título
        this.numEscapesGroup = 0; // Valor por defecto para escapes grupales
        this.numEscapesOrganized = 0; // Valor por defecto para escapes organizados
        this.numPlans = 0; // Valor por defecto para planes
        this.numPlansOrganized = 0; // Valor por defecto para planes organizados
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public LocalDate getlastEscape() {
        return lastEscape;
    }

    public void setlastEscape(LocalDate lastEscape) {
        this.lastEscape = lastEscape;
    }

    public Integer getNumEscapes() {
        return numEscapes;
    }

    public void setNumEscapes(Integer numEscapes) {
        this.numEscapes = numEscapes;
    }

    public Integer getNumEscapesGroup() {
        return numEscapesGroup;
    }

    public void setNumEscapesGroup(Integer numEscapesGroup) {
        this.numEscapesGroup = numEscapesGroup;
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

    
    
}







