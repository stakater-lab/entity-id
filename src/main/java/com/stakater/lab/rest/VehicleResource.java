package com.stakater.lab.rest;

import com.stakater.lab.service.VehicleService;
import com.stakater.lab.support.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
public class VehicleResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleResource.class);
    private static final String ENTITY_NAME = "vehicle";

    private final VehicleService vehicleService;

    @Autowired
    public VehicleResource(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<ApiVehicle> createProvider(@RequestBody CreateVehicleRequest createVehicleRequest) throws URISyntaxException {
        LOGGER.debug("REST request to save Vehicle : {}", createVehicleRequest);
        ApiVehicle result = vehicleService.save(createVehicleRequest);
        return ResponseEntity.created(new URI("/api/vehicles/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<ApiVehicle> getVehicle(@PathVariable Long id) {
        LOGGER.debug("REST request to get Vehicle : {}", id);
        Optional<ApiVehicle> providerDTO = vehicleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(providerDTO);
    }

}
