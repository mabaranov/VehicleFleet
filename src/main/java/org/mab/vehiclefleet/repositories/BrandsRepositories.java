package org.mab.vehiclefleet.repositories;

import org.mab.vehiclefleet.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepositories extends JpaRepository<Brand, Integer> {
}