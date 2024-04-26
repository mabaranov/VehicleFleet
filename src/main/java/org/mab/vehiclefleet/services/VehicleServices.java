package org.mab.vehiclefleet.services;

import org.mab.vehiclefleet.models.Vehicle;
import org.mab.vehiclefleet.repositories.VehiclesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VehicleServices {

    private final VehiclesRepositories vehiclesRepositories;

    @Autowired
    public VehicleServices(VehiclesRepositories vehiclesRepositories) {
        this.vehiclesRepositories = vehiclesRepositories;
    }

    public List<Vehicle> findAll() {
        List<Vehicle> p = vehiclesRepositories.findAll();
        for(int i=0; i<p.size(); i++)
            System.out.println(p.get(i));
        return vehiclesRepositories.findAll();
    }

    public Vehicle findOne(int id) {
        Optional<Vehicle> foundVehicle = vehiclesRepositories.findById(id);
        return foundVehicle.orElse(null);
    }

    @Transactional
    public void save(Vehicle vehicle) {
        vehiclesRepositories.save(vehicle);
    }

    @Transactional
    public void delete(int id) {
        vehiclesRepositories.deleteById(id);
    }

    @Transactional
    public void update(int id, Vehicle updatedVehicle) {
        updatedVehicle.setId(id);
        vehiclesRepositories.save(updatedVehicle);
    }
}