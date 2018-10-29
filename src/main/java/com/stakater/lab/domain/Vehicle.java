package com.stakater.lab.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Why NoArgsConstructor? just for dehydration! as no args ctor is used to create object & then fields are set using refection!
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Getter
@JsonDeserialize(builder = Vehicle.Builder.class)
@Entity
@Table(name = "vehicle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Vehicle {

    // unique identifier of vehicle entity
    @Id
    private final Long id;

    // registration number
    @Column(name = "reg_no", nullable = false, unique = true)
    private final String regNo;

    @lombok.Builder(builderClassName = "Builder", builderMethodName = "newBuilder", toBuilder = true)
    private Vehicle(Long id, String regNo) {
        this.id = id;
        this.regNo = regNo;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}
