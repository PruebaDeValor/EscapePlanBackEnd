package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto;

import jakarta.validation.constraints.NotNull;

public class PersonSessionDto {
    @NotNull(message = "Person ID cannot be null")
    private Long personId;

    // Puedes añadir más campos según tu modelo, por ejemplo:
    // private String role;
    // private Boolean confirmed;

    public PersonSessionDto() {}

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    // Getters y setters para los campos adicionales
}
