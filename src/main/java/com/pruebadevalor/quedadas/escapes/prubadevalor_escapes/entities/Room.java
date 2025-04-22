package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name; // Nombre de la escape

    @Size(max = 150, message = "Short description cannot be longer than 150 characters")
    private String shortDescription; // Descripción corta para mostrar en listados

    @Size(max = 1000, message = "Long description cannot be longer than 1000 characters")
    private String longDescription; // Descripción detallada

    @Size(max = 100, message = "Theme cannot be longer than 100 characters")
    private String theme; // Temática de la escape room

    private String imageName; // Nombre del archivo de imagen

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; // Local en el que se encuentra la escape room

    public Room() {
        // Constructor vacío
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
