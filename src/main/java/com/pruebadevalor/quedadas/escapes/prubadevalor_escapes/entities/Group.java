package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name; // Nombre del grupo

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description; // Descripción del grupo

    @Size(max = 50, message = "City cannot be longer than 50 characters")
    private String baseCity; // Ciudad base del grupo

    @Size(max = 100, message = "Logo file name cannot be longer than 100 characters")
    private String logoFileName; // Nombre del archivo de imagen/logo del grupo

    @Min(value = 1, message = "Title must be at least 1")
    private Integer title; // Título numérico (ej: 1 = Recién creado, 10 = Hermandad legendaria)

    @OneToMany(mappedBy = "group")
    private List<PersonGroup> personGroups; // Lista de relaciones Person-Group

    @OneToMany
    @JoinColumn(name = "group_id") // Relación inversa desde PersonGroup
    private List<Person> members; // Lista de personas en este grupo (esto es opcional)

    // Constructor vacío requerido por JPA
    public Group() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseCity() {
        return baseCity;
    }

    public void setBaseCity(String baseCity) {
        this.baseCity = baseCity;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public List<PersonGroup> getPersonGroups() {
        return personGroups;
    }

    public void setPersonGroups(List<PersonGroup> personGroups) {
        this.personGroups = personGroups;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

}
