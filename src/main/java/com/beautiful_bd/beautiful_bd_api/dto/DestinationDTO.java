package com.beautiful_bd.beautiful_bd_api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

public class DestinationDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Zilla is required")
    private String zilla;

    // @NotBlank(message = "Upazilla is required")
    private String upazilla;

    private String description;

    private String mapsUrl;
    private List<String> imageUrls;
    private List<HotelDTO> hotels;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getZilla() {
        return zilla;
    }

    public String getUpazilla() {
        return upazilla;
    }

    public String getDescription() {
        return description;
    }

    public String getMapsUrl() {
        return mapsUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZilla(String zilla) {
        this.zilla = zilla;
    }

    public void setUpazilla(String upazilla) {
        this.upazilla = upazilla;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMapsUrl(String mapsUrl) {
        this.mapsUrl = mapsUrl;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<HotelDTO> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelDTO> hotels) {
        this.hotels = hotels;
    }
}
