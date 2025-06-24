package com.beautiful_bd.beautiful_bd_api.controller;

import com.beautiful_bd.beautiful_bd_api.dto.DestinationDTO;
import com.beautiful_bd.beautiful_bd_api.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public DestinationDTO create(@RequestBody @Valid DestinationDTO dto) {
        return service.createDestination(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody @Valid DestinationDTO dto) {
//        return service.updateDestination(id, dto);
        DestinationDTO updated = service.updateDestination(id, dto);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Destination updated successfully");
        response.put("data", updated);

        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDestination(@PathVariable Long id) {
        service.deleteDestinationById(id);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Destination deleted successfully");

        return ResponseEntity.status(200).body(response);
    }
}
