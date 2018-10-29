package com.stakater.lab.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Value;

@SuppressWarnings("unused")
@Value
@JsonDeserialize(builder = CreateVehicleRequest.Builder.class)
public class CreateVehicleRequest {

    private final String regNo;

    @lombok.Builder(builderClassName = "Builder", builderMethodName = "newBuilder", toBuilder = true)
    private CreateVehicleRequest(String regNo) {
        this.regNo = regNo;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}