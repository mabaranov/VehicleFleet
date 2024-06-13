package org.mab.vehiclefleet.repositories;

import org.mab.vehiclefleet.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriversRepositories extends JpaRepository<Driver, Integer> {
}