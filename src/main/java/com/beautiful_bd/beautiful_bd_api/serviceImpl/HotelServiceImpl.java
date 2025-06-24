package com.beautiful_bd.beautiful_bd_api.serviceImpl;

import com.beautiful_bd.beautiful_bd_api.dto.HotelDTO;
import com.beautiful_bd.beautiful_bd_api.model.Hotel;
import com.beautiful_bd.beautiful_bd_api.service.HotelService;

public class HotelServiceImpl implements HotelService {

    public HotelDTO mapToDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();

        dto.setId(hotel.getId());
        dto.setAddress(hotel.getAddress());
        dto.setName(hotel.getName());

        return dto;
    }
}
