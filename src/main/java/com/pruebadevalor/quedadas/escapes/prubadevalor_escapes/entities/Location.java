package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name; // Nombre del local

    @Size(max = 255, message = "Address cannot be longer than 255 characters")
    private String address; // Dirección del local

    @Size(max = 100, message = "City cannot be longer than 100 characters")
    private String city; // Ciudad del local

    @Size(max = 50, message = "Contact number cannot be longer than 50 characters")
    private String contactNumber; // Número de contacto del local

    @Size(max = 100, message = "Website URL cannot be longer than 100 characters")
    private String websiteUrl; // URL del sitio web del local

    @Size(max = 500, message = "Google Maps URL cannot be longer than 500 characters")
    private String googleMapsUrl; // Enlace a Google Maps

    @Size(max = 100, message = "Latitude and Longitude cannot be longer than 100 characters")
    private String latitudeAndLongitudeString; // Latitud y Longitud

    // Constructor vacío requerido por JPA
    public Location() {
    }

    // Constructor con todos los parámetros
    public Location(String name, String address, String city, String contactNumber, String websiteUrl, String googleMapsUrl, String latitudeAndLongitudeString) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.contactNumber = contactNumber;
        this.websiteUrl = websiteUrl;
        this.googleMapsUrl = googleMapsUrl;
        this.latitudeAndLongitudeString = latitudeAndLongitudeString;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public String getLatitudeAndLongitudeString() {
        return latitudeAndLongitudeString;
    }

    public void setLatitudeAndLongitudeString(String latitudeAndLongitudeString) {
        this.latitudeAndLongitudeString = latitudeAndLongitudeString;
    }

    // Método toString para facilitar la depuración
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                ", latitudeAndLongitudeString='" + latitudeAndLongitudeString + '\'' +
                '}';
    }
}