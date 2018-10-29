package com.stakater.lab.mapper;

import com.stakater.lab.domain.Vehicle;
import com.stakater.lab.rest.ApiVehicle;

@SuppressWarnings("unused")
public class VehicleMapper {

    public static ApiVehicle toApiVehicle(Vehicle vehicle) {
        return ApiVehicle.newBuilder().id(vehicle.getId()).regNo(vehicle.getRegNo()).build();
    }

}
