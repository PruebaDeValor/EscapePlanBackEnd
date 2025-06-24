package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "person_groups")
public class PersonGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Person cannot be null")
    private Person person; // Persona asociada al grupo

    @ManyToOne
    @JoinColumn(name = "escape_group_id", nullable = false)
    private EscapeGroup escapeGroup; // Grupo de escape al que pertenece la persona

    @NotNull(message = "Registration date cannot be null")
    private LocalDate registrationDate; // Fecha de registro de la persona en el grupo

    public enum Role {
        ADMIN,
        MODERATOR,
        MEMBER,
        CANDIDATE,//A prueba
        EXTERNAL,//hace planes con el grupo, pero no escapes, o al menos no de forma frecuente.
        EDITOR
        
    }
    //rol del usuario

    public enum Status {
        ACTIVE,
        AWAY,
        INVITED,//invitado al grupo, aún no ha aceptado la invitación
        PENDING,//ha solicitado unirse al grupo, pero aún no ha sido aceptado
        BANNED
    }

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role cannot be null")
    private Role role; // Rol de la persona dentro del grupo (puede ser MEMBER, LEADER, INVITED, PENDING)

    private Integer title; // Título numérico del grupo, similar a lo que tenías en Person

    private LocalDate lastEscape; // Fecha del último escape con el grupo

    private Integer numEscapesGroup; // Número de escapes realizados con este grupo

    private Integer numEscapesGroupOrganized; // Número de escapes organizados con este grupo

    private Integer numPlansGroup; // Número de planes realizados con este grupo

    private Integer numPlansGroupOrganized; // Número de planes organizados con este grupo

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status cannot be null")
    private Status status; // Estado de la persona en el grupo (puede ser ACTIVE, AWAY, INVITED, PENDING, BANNED)

    // Constructor con todos los parámetros
    public PersonGroup(Person person, EscapeGroup escapeGroup, LocalDate registrationDate, Role role, Integer title,
                       LocalDate lastEscape, Integer numEscapesGroup, Integer numEscapesGroupOrganized,
                       Integer numPlansGroup, Integer numPlansGroupOrganized, Status status) {
        this.person = person;
        this.escapeGroup = escapeGroup;
        this.registrationDate = registrationDate;
        this.role = role;
        this.title = title;
        this.lastEscape = lastEscape;
        this.numEscapesGroup = numEscapesGroup;
        this.numEscapesGroupOrganized = numEscapesGroupOrganized;
        this.numPlansGroup = numPlansGroup;
        this.numPlansGroupOrganized = numPlansGroupOrganized;
    }

    public PersonGroup() {
        // Constructor vacío
    }

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

    public EscapeGroup getEscapeGroup() {
        return escapeGroup;
    }

    public void setEscapeGroup(EscapeGroup escapeGroup) {
        this.escapeGroup = escapeGroup;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public LocalDate getLastEscape() {
        return lastEscape;
    }

    public void setLastEscape(LocalDate lastEscape) {
        this.lastEscape = lastEscape;
    }

    public Integer getNumEscapesGroup() {
        return numEscapesGroup;
    }

    public void setNumEscapesGroup(Integer numEscapesGroup) {
        this.numEscapesGroup = numEscapesGroup;
    }

    public Integer getNumEscapesGroupOrganized() {
        return numEscapesGroupOrganized;
    }

    public void setNumEscapesGroupOrganized(Integer numEscapesGroupOrganized) {
        this.numEscapesGroupOrganized = numEscapesGroupOrganized;
    }

    public Integer getNumPlansGroup() {
        return numPlansGroup;
    }

    public void setNumPlansGroup(Integer numPlansGroup) {
        this.numPlansGroup = numPlansGroup;
    }

    public Integer getNumPlansGroupOrganized() {
        return numPlansGroupOrganized;
    }

    public void setNumPlansGroupOrganized(Integer numPlansGroupOrganized) {
        this.numPlansGroupOrganized = numPlansGroupOrganized;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Getters y Setters

    

   

    
}
