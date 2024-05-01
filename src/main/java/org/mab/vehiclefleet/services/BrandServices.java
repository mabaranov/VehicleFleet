package org.mab.vehiclefleet.services;

import org.mab.vehiclefleet.models.Brand;
import org.mab.vehiclefleet.repositories.BrandsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BrandServices {

    private final BrandsRepositories brandsRepositories;

    @Autowired
    public BrandServices(BrandsRepositories brandsRepositories) {
        this.brandsRepositories = brandsRepositories;
    }

    public List<Brand> findAll() {
        List<Brand> p = brandsRepositories.findAll();
        for(int i=0; i<p.size(); i++)
            System.out.println(p.get(i));
        return brandsRepositories.findAll();
    }

    public Brand findOne(int id) {
        Optional<Brand> foundVehicle = brandsRepositories.findById(id);
        return foundVehicle.orElse(null);
    }

    @Transactional
    public void save(Brand vehicle) {
        brandsRepositories.save(vehicle);
    }

    @Transactional
    public void delete(int id) {
        brandsRepositories.deleteById(id);
    }

    @Transactional
    public void update(int id, Brand updatedBrand) {
        updatedBrand.setId(id);
        brandsRepositories.save(updatedBrand);
    }
}