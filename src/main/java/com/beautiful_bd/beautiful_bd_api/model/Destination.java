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
    @CollectionTable(name = "destination_images", joinColumns = @JoinColumn(name = "destination_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotel> hotels;
}
