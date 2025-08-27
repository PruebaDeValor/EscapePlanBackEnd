package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
    private EscapeGroup escapeGroup; // Grupo de escape al que pertenece la sesión

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Positive(message = "Duration must be positive")
    private Integer durationMinutes;

    public enum Status {
        COMPLETED,
        PENDING        
    }

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status cannot be null")
    private Status status;

    @Size(max = 1000, message = "Notes cannot be longer than 1000 characters")
    private String notes;

    @ManyToOne(optional = false)
    private Person organizedBy; // Persona que organiza la sesión

    @Min(value = 1, message = "Requested capacity must be at least 1")
    @NotNull(message = "Requested capacity cannot be null")
    private Long requestedCapacity;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonSession> personSessions;

    private Boolean fullCapacity;

    



    // Constructor vacío requerido por JPA
    public Session() {
    }

    // Constructor con todos los parámetros
    public Session(@NotNull(message = "Room cannot be null") Room room, EscapeGroup escapeGroup,
            @NotNull(message = "Start time cannot be null") LocalDateTime startTime, LocalDateTime endTime,
            @Positive(message = "Duration must be positive") Integer durationMinutes,
            @NotNull(message = "Status cannot be null") Status status,
            @Size(max = 1000, message = "Notes cannot be longer than 1000 characters") String notes, Person organizedBy,
            @Min(value = 1, message = "Requested capacity must be at least 1") @NotNull(message = "Requested capacity cannot be null") Long requestedCapacity,
            List<PersonSession> personSessions, Boolean fullCapacity) {
        this.room = room;
        this.escapeGroup = escapeGroup;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationMinutes = durationMinutes;
        this.status = status;
        this.notes = notes;
        this.organizedBy = organizedBy;
        this.requestedCapacity = requestedCapacity;
        this.personSessions = personSessions;
        this.fullCapacity = fullCapacity;
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

    public EscapeGroup getEscapeGroup() {
        return escapeGroup;
    }

    public void setEscapeGroup(EscapeGroup escapeGroup) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status pending) {
        this.status = pending;
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

    public Long getRequestedCapacity() {
        return requestedCapacity;
    }

    public void setRequestedCapacity(Long requestedCapacity) {
        this.requestedCapacity = requestedCapacity;
    }

    public List<PersonSession> getPersonSessions() {
        return personSessions;
    }

    public void setPersonSessions(List<PersonSession> sessionMembers) {
        this.personSessions = sessionMembers;
    }

    public boolean isFullCapacity() {
    return fullCapacity != null ? fullCapacity : false;
    }

    public Boolean getFullCapacity() {
        return fullCapacity;
    }

    public void setFullCapacity(Boolean fullCapacity) {
    this.fullCapacity = fullCapacity;
    }

    @Override
    public String toString() {
        return "Session [id=" + id + ", room=" + room + ", escapeGroup=" + escapeGroup + ", startTime=" + startTime
                + ", endTime=" + endTime + ", durationMinutes=" + durationMinutes + ", status=" + status + ", notes="
                + notes + ", organizedBy=" + organizedBy + ", requestedCapacity=" + requestedCapacity
                + ", personSessions=" + personSessions + ", fullCapacity=" + fullCapacity + "]";
    }

    
}
