package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name; // Nombre del plan

    @Size(max = 150, message = "Short description cannot be longer than 150 characters")
    private String shortDescription; // Descripción corta

    @Size(max = 1000, message = "Long description cannot be longer than 1000 characters")
    private String longDescription; // Descripción larga

    @Min(value = 1, message = "Minimum number of people must be at least 1")
    private Integer minPeople; // Número mínimo de personas

    @Min(value = 1, message = "Maximum number of people must be at least 1")
    private Integer maxPeople; // Número máximo de personas

    @ManyToOne(optional = false)
    private Person organizer; // Persona que organiza el plan

    @ManyToOne
    @JoinColumn(name = "escape_group_id", nullable = true)
    private EscapeGroup escapeGroup;

    @Size(max = 255, message = "URL cannot be longer than 255 characters")
    private String url; // URL del plan

    @Size(max = 500, message = "Google Maps URL cannot be longer than 500 characters")
    private String googleMapsUrl; // Dirección de Google Maps

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be at least 0")
    private BigDecimal price; // Precio del plan

    @Pattern(
        regexp = "([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp))$)?",
        message = "Image name must have a valid format (jpg, jpeg, png, gif, bmp)"
    )
    @Size(max = 100, message = "Image name cannot be longer than 100 characters")
    private String imageName; // Nombre del archivo de imagen

    @Size(max = 255, message = "Address cannot be longer than 255 characters")
    private String address; // Dirección del plan

    // Constructor vacío requerido por JPA
    public Plan() {
    }
    // Constructor con todos los parámetros
    public Plan(String name, String shortDescription, String longDescription, Integer minPeople,
                Integer maxPeople, Person organizer, EscapeGroup escapeGroup, String url,
                String googleMapsUrl, BigDecimal price, String imageName, String address) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.minPeople = minPeople;
        this.maxPeople = maxPeople;
        this.organizer = organizer;
        this.escapeGroup = escapeGroup;
        this.url = url;
        this.googleMapsUrl = googleMapsUrl;
        this.price = price;
        this.imageName = imageName;
        this.address = address;
    }

    // Getters y Setters

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

    public Integer getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(Integer minPeople) {
        this.minPeople = minPeople;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public EscapeGroup getEscapeGroup() {
        return escapeGroup;
    }

    public void setEscapeGroup(EscapeGroup escapeGroup) {
        this.escapeGroup = escapeGroup;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
