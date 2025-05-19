package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    @Size(min = 1, message = "Name must be at least 1 character")
    private String name; // Nombre de la encuesta

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String shortDescription; // Descripción de la encuesta

    @Size(max = 1000, message = "Questions cannot be longer than 1000 characters")
    private String longDescription; // Descripción larga

    private LocalDateTime startDate; // Fecha de inicio de la encuesta

    private LocalDateTime endDate; // Fecha de fin de la encuesta

    @Size(max = 100, message = "Status cannot be longer than 100 characters")
    private String question; // Pregunta de la encuesta

    @ElementCollection
    @CollectionTable(name = "survey_options", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "option_text")
    private List<String> options; // Opciones de la encuesta

    @ManyToOne
    @NotNull(message = "Room cannot be null")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "escape_group_id", nullable = false)
    private EscapeGroup escapeGroup; // Grupo de escape al que pertenece la encuesta

    // Constructor con todos los parámetros
    public Survey(String name, String shortDescription, String longDescription,
                   LocalDateTime startDate, LocalDateTime endDate, String question,
                   List<String> options, Room room, EscapeGroup escapeGroup) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.question = question;
        this.options = options;
        this.room = room;
        this.escapeGroup = escapeGroup;
    }

    // Constructor vacío requerido por JPA
    public Survey() {
    }
    
    // Getters y setters

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public EscapeGroup getEscapeGroup() {
        return escapeGroup;
    }

    public void setEscapeGroup(EscapeGroup escapeGroup) {
        this.escapeGroup = escapeGroup;
    }

    
}
