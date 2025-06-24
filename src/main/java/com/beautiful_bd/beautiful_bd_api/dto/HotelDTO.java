package com.beautiful_bd.beautiful_bd_api.dto;

import jakarta.validation.constraints.NotBlank;

public class HotelDTO {
    private Long id;

    @NotBlank(message = "Hotel name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    public Long getId() { return id; }

    public void setId(Long id) {this.id = id; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
