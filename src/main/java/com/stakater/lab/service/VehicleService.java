package com.stakater.lab.service;

import com.stakater.lab.domain.Vehicle;
import com.stakater.lab.mapper.VehicleMapper;
import com.stakater.lab.repository.VehicleRepository;
import com.stakater.lab.rest.ApiVehicle;
import com.stakater.lab.rest.CreateVehicleRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SuppressWarnings("unused")
@Service
@Transactional
public class VehicleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public ApiVehicle save(CreateVehicleRequest createVehicleRequest) {
        Long id = vehicleRepository.getNextIdentity();
        Vehicle vehicle = Vehicle.newBuilder().id(id).regNo(createVehicleRequest.getRegNo()).build();
        vehicle = vehicleRepository.save(vehicle);
        return ApiVehicle.newBuilder().id(vehicle.getId()).regNo(vehicle.getRegNo()).build();
    }

    @Transactional(readOnly = true)
    public Optional<ApiVehicle> findOne(Long id) {
        LOGGER.debug("Request to get Vehicle : {}", id);
        return vehicleRepository.findById(id)
                .map(VehicleMapper::toApiVehicle);

    }
}
