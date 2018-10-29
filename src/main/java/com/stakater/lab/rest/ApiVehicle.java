package com.stakater.lab.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Value;

@SuppressWarnings("unused")
@Value
@JsonDeserialize(builder = ApiVehicle.Builder.class)
public class ApiVehicle {

    private final Long id;
    private final String regNo;

    @JsonCreator
    @lombok.Builder(builderClassName = "Builder", builderMethodName = "newBuilder", toBuilder = true)
    private ApiVehicle(Long id, String regNo) {
        this.id = id;
        this.regNo = regNo;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}
