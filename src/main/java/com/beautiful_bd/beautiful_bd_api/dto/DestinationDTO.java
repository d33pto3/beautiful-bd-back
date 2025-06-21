package com.beautiful_bd.beautiful_bd_api.dto;

import java.util.List;

public class DestinationDTO {
    private String name;
    private String zilla;
    private String upazilla;
    private String description;
    private String mapsUrl;
    private List<String> imageUrls;
    private List<HotelDTO> hotels;

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
