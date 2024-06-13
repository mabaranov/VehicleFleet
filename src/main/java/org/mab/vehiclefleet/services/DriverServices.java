package org.mab.vehiclefleet.services;

import org.hibernate.Hibernate;
import org.mab.vehiclefleet.models.Brand;
import org.mab.vehiclefleet.models.Driver;
import org.mab.vehiclefleet.repositories.BrandsRepositories;
import org.mab.vehiclefleet.repositories.DriversRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DriverServices {

    private final DriversRepositories driversRepositories;

    @Autowired
    public DriverServices(DriversRepositories driversRepositories) {
        this.driversRepositories = driversRepositories;
    }

    public List<Driver> findAll() {
        List<Driver> p = driversRepositories.findAll();
        for(int i=0; i<p.size(); i++)
            System.out.println(p.get(i));

        //Hibernate.initialize(driversRepositories.findAll());
        return driversRepositories.findAll();
    }

    public Driver findOne(int id) {
        Optional<Driver> foundDriver = driversRepositories.findById(id);
        return foundDriver.orElse(null);
    }

    @Transactional
    public void save(Driver vehicle) {
        driversRepositories.save(vehicle);
    }

    @Transactional
    public void delete(int id) {
        driversRepositories.deleteById(id);
    }

    @Transactional
    public void update(int id, Driver updatedDriver) {
        updatedDriver.setId(id);
        driversRepositories.save(updatedDriver);
    }
}