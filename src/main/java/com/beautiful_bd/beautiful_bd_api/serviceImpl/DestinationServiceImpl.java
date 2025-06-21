package com.beautiful_bd.beautiful_bd_api.serviceImpl;

import com.beautiful_bd.beautiful_bd_api.dto.DestinationDTO;
import com.beautiful_bd.beautiful_bd_api.dto.HotelDTO;
import com.beautiful_bd.beautiful_bd_api.model.Destination;
import com.beautiful_bd.beautiful_bd_api.model.Hotel;
import com.beautiful_bd.beautiful_bd_api.repository.DestinationRepository;
import com.beautiful_bd.beautiful_bd_api.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository repository;

    @Override
    public List<DestinationDTO> getAllDestinations() {
       return repository.findAll().stream()
               .map(this::convertToDTO)
               .collect(Collectors.toList());
    }

    @Override
    public DestinationDTO getDestinationById(Long id) {
       Destination destination = repository.findById(id).orElseThrow();
       return convertToDTO(destination);
    }

    @Override
    public DestinationDTO createDestination(DestinationDTO dto) {
        Destination destination = convertToEntity(dto);
        Destination saved = repository.save(destination);

        return convertToDTO(saved);
    }

    @Override
    public void deleteDestinationById(Long id) {
        repository.deleteById(id);
    }

    // Mappers

    private DestinationDTO convertToDTO(Destination d) {
        DestinationDTO dto = new DestinationDTO();
        dto.setName(d.getName());
        dto.setZilla(d.getZilla());
        dto.setUpazilla(d.getUpazilla());
        dto.setDescription(d.getDescription());
        dto.setImageUrls(d.getImageUrls());

        List<HotelDTO> hotelDTOS = d.getHotels().stream().map(h -> {
            HotelDTO hDto = new HotelDTO();
            hDto.setName(h.getName());
            hDto.setAddress(h.getAddress());

            return hDto;
        }).collect(Collectors.toList());

        dto.setHotels(hotelDTOS);
        return dto;
    }

    private Destination convertToEntity(DestinationDTO dto) {
        Destination d = new Destination();
        d.setName(dto.getName());
        d.setZilla(dto.getZilla());
        d.setUpazilla(dto.getUpazilla());
        d.setDescription(dto.getDescription());
        d.setImageUrls(dto.getImageUrls());

        List<Hotel> hotels = dto.getHotels().stream().map(hDto -> {
            Hotel hotel = new Hotel();
            hotel.setName(hDto.getName());
            hotel.setAddress(hDto.getAddress());

            // Initialize destinations list if null
            if(hotel.getDestinations() == null) {
                hotel.setDestinations(new ArrayList<>());
            }

            // Add this destination to hotel's destinations list
            hotel.getDestinations().add(d);

            return hotel;
        }).collect(Collectors.toList());

        d.setHotels(hotels);
        return d;
    }
}
