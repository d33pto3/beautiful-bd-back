package com.beautiful_bd.beautiful_bd_api.serviceImpl;

import com.beautiful_bd.beautiful_bd_api.dto.DestinationDTO;
import com.beautiful_bd.beautiful_bd_api.dto.HotelDTO;
import com.beautiful_bd.beautiful_bd_api.model.Destination;
import com.beautiful_bd.beautiful_bd_api.model.Hotel;
import com.beautiful_bd.beautiful_bd_api.repository.DestinationRepository;
import com.beautiful_bd.beautiful_bd_api.service.DestinationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Destination with ID " + id + " not found");
        }

        repository.deleteById(id);
    }

    // Mappers

    private DestinationDTO convertToDTO(Destination d) {
        DestinationDTO dto = new DestinationDTO();
        dto.setId(d.getId());
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
        Destination destination = new Destination();
        destination.setName(dto.getName());
        destination.setZilla(dto.getZilla());
        destination.setUpazilla(dto.getUpazilla());
        destination.setDescription(dto.getDescription());
        destination.setImageUrls(dto.getImageUrls());

        // Only map hotels if the list is not null and not empty
        List<HotelDTO> hotelDTOs = dto.getHotels();
        if (hotelDTOs != null && !hotelDTOs.isEmpty()) {
            List<Hotel> hotels = hotelDTOs.stream().map(hDto -> {
                Hotel hotel = new Hotel();
                hotel.setName(hDto.getName());
                hotel.setAddress(hDto.getAddress());
                hotel.setDestinations(new ArrayList<>(List.of(destination)));
                return hotel;
            }).collect(Collectors.toList());

            destination.setHotels(hotels);
        } else {
            destination.setHotels(new ArrayList<>());
        }

        return destination;
    }
}
