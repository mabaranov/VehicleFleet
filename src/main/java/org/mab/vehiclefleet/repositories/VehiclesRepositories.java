package org.mab.vehiclefleet.repositories;

import org.mab.vehiclefleet.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepositories extends JpaRepository<Vehicle, Integer> {
}