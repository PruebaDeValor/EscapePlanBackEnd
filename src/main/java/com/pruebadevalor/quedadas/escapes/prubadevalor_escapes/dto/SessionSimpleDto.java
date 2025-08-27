package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SessionSimpleDto {
    private Long id;

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Positive(message = "Duration must be positive")
    private Integer durationMinutes;

    public enum Status {
        COMPLETED,
        PENDING
    }

    @NotNull(message = "Status cannot be null")
    private Status status;

    @Size(max = 1000, message = "Notes cannot be longer than 1000 characters")
    private String notes;

    @NotNull(message = "Requested capacity cannot be null")
    @Min(value = 1, message = "Requested capacity must be at least 1")
    private Long requestedCapacity;

    private boolean fullCapacity;

    @NotNull(message = "Person sessions cannot be null")
    private List<PersonSessionDto> personSessions;

    public SessionSimpleDto() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Long getRequestedCapacity() {
        return requestedCapacity;
    }

    public void setRequestedCapacity(Long requestedCapacity) {
        this.requestedCapacity = requestedCapacity;
    }

    public boolean isFullCapacity() {
        return fullCapacity;
    }

    public void setFullCapacity(boolean fullCapacity) {
        this.fullCapacity = fullCapacity;
    }

    public List<PersonSessionDto> getPersonSessions() {
        return personSessions;
    }

    public void setPersonSessions(List<PersonSessionDto> personSessions) {
        this.personSessions = personSessions;
    }

    

    
}
