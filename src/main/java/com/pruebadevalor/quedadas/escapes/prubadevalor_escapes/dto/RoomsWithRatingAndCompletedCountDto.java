package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto;

public class RoomsWithRatingAndCompletedCountDto {
	private Long id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private Long minimumCapacity;
	private Long maximumCapacity;
	private Boolean isScary;
	private String theme;
	private String imageName;
	private String websiteUrl;
	private Long locationId;
	private String locationName;
	private Double averageRating; // Promedio de las valoraciones
	private Long completedCount; // Número de personas que han completado la room

	public RoomsWithRatingAndCompletedCountDto() {}

	public RoomsWithRatingAndCompletedCountDto(Long id, String name, String shortDescription, String longDescription,
							  Long minimumCapacity, Long maximumCapacity, Boolean isScary, String theme,
							  String imageName, String websiteUrl, Long locationId, String locationName,
							  Double averageRating, Long completedCount) {
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.minimumCapacity = minimumCapacity;
		this.maximumCapacity = maximumCapacity;
		this.isScary = isScary;
		this.theme = theme;
		this.imageName = imageName;
		this.websiteUrl = websiteUrl;
		this.locationId = locationId;
		this.locationName = locationName;
		this.averageRating = averageRating;
		this.completedCount = completedCount;
	}

	// Getters y setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getShortDescription() { return shortDescription; }
	public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

	public String getLongDescription() { return longDescription; }
	public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

	public Long getMinimumCapacity() { return minimumCapacity; }
	public void setMinimumCapacity(Long minimumCapacity) { this.minimumCapacity = minimumCapacity; }

	public Long getMaximumCapacity() { return maximumCapacity; }
	public void setMaximumCapacity(Long maximumCapacity) { this.maximumCapacity = maximumCapacity; }

	public Boolean getIsScary() { return isScary; }
	public void setIsScary(Boolean isScary) { this.isScary = isScary; }

	public String getTheme() { return theme; }
	public void setTheme(String theme) { this.theme = theme; }

	public String getImageName() { return imageName; }
	public void setImageName(String imageName) { this.imageName = imageName; }

	public String getWebsiteUrl() { return websiteUrl; }
	public void setWebsiteUrl(String websiteUrl) { this.websiteUrl = websiteUrl; }

	public Long getLocationId() { return locationId; }
	public void setLocationId(Long locationId) { this.locationId = locationId; }

	public String getLocationName() { return locationName; }
	public void setLocationName(String locationName) { this.locationName = locationName; }

	public Double getAverageRating() { return averageRating; }
	public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }

	public Long getCompletedCount() { return completedCount; }
	public void setCompletedCount(Long completedCount) { this.completedCount = completedCount; }
}
