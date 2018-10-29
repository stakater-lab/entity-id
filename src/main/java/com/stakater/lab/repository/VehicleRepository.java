package com.stakater.lab.repository;

import com.stakater.lab.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "SELECT nextval(pg_get_serial_sequence('vehicle', 'id'))", nativeQuery = true)
    Long getNextIdentity();
}
