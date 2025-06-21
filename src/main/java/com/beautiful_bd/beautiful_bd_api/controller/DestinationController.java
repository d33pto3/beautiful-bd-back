package com.beautiful_bd.beautiful_bd_api.controller;

import com.beautiful_bd.beautiful_bd_api.dto.DestinationDTO;
import com.beautiful_bd.beautiful_bd_api.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    private DestinationService service;

    @GetMapping
    public List<DestinationDTO> getAll() {
        return service.getAllDestinations();
    }

    @GetMapping("/{id}")
    public DestinationDTO getById(@PathVariable Long id) {
        return service.getDestinationById(id);
    }

    @PostMapping()
    public DestinationDTO create(@RequestBody DestinationDTO dto) {
        return service.createDestination(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDestinationById(id);
    }
}
