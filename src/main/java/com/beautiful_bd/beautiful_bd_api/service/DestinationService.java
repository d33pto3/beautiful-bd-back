package com.beautiful_bd.beautiful_bd_api.service;

import com.beautiful_bd.beautiful_bd_api.dto.DestinationDTO;

import java.util.List;

public interface DestinationService {
    List<DestinationDTO> getAllDestinations();
    DestinationDTO getDestinationById(Long id);

    DestinationDTO createDestination(DestinationDTO dto);
    void deleteDestinationById(Long id);

    DestinationDTO updateDestination(Long id, DestinationDTO dto);
}
