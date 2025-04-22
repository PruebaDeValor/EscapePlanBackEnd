package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import java.time.LocalDateTime;
import java.util.List;

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
    private Group group; // Puede ser null si la sesión no pertenece a ningún grupo

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
    private Person organizedBy;

    @OneToMany(mappedBy = "session")
    private List<PersonSession> personSessions;

    public Session() {}

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public List<PersonSession> getPersonSessions() {
        return personSessions;
    }

    public void setPersonSessions(List<PersonSession> personSessions) {
        this.personSessions = personSessions;
    }
}
