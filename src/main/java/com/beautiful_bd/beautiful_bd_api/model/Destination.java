package com.beautiful_bd.beautiful_bd_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String zilla;
    private String upazilla;
    private String description;
    private String mapsUrl;

    @ElementCollection
    @CollectionTable(
            name = "destination_images",
            joinColumns = @JoinColumn(name = "destination_id")
    )
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany
    @JoinTable(
            name = "destination_hotels",
            joinColumns = @JoinColumn(name = "destination_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )
    private List<Hotel> hotels;

    // Getters and Setters

    public Long getId() {
        return id;
    }

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

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public String description() {
        return description;
    }

    public String mapsUrl() {
        return mapsUrl;
    }

    public List<String> imageUrls() {
        return imageUrls;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

//    public void setImageUrl(String imageUrl) {
//        this.imageUrls.add(imageUrl);
//    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}