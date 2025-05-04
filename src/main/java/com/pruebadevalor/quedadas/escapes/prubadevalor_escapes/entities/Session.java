package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Room cannot be null")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "escape_group_id", nullable = false)
    private escapeGroup escapeGroup; // Grupo de escape al que pertenece la sesión

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Positive(message = "Duration must be positive")
    private Integer durationMinutes;

    @NotBlank(message = "Status cannot be empty")
    private String status;

    @Size(max = 1000, message = "Notes cannot be longer than 1000 characters")
    private String notes;

    @ManyToOne(optional = false)
    private Person organizedBy; // Persona que organiza la sesión

    // Constructor vacío requerido por JPA
    public Session() {
    }

    // Constructor con todos los parámetros
    public Session(Room room, escapeGroup escapeGroup, LocalDateTime startTime, LocalDateTime endTime,
                   Integer durationMinutes, String status, String notes, Person organizedBy) {
        this.room = room;
        this.escapeGroup = escapeGroup;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationMinutes = durationMinutes;
        this.status = status;
        this.notes = notes;
        this.organizedBy = organizedBy;
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

    public escapeGroup getEscapeGroup() {
        return escapeGroup;
    }

    public void setEscapeGroup(escapeGroup escapeGroup) {
        this.escapeGroup = escapeGroup;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Person getOrganizedBy() {
        return organizedBy;
    }

    public void setOrganizedBy(Person organizedBy) {
        this.organizedBy = organizedBy;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", room=" + room +
                ", group=" + escapeGroup +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", durationMinutes=" + durationMinutes +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                ", organizedBy=" + organizedBy +
                '}';
    }
}
