package org.mab.vehiclefleet.repositories;

import org.mab.vehiclefleet.models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterprisesRepositories extends JpaRepository<Enterprise, Integer> {
}