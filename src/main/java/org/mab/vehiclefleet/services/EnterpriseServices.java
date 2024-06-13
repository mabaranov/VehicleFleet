package org.mab.vehiclefleet.services;


import org.mab.vehiclefleet.models.Enterprise;
import org.mab.vehiclefleet.repositories.EnterprisesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EnterpriseServices {

    private final EnterprisesRepositories enterprisesRepositories;

    @Autowired
    public EnterpriseServices(EnterprisesRepositories enterprisesRepositories) {
        this.enterprisesRepositories = enterprisesRepositories;
    }

    public List<Enterprise> findAll() {
        List<Enterprise> p = enterprisesRepositories.findAll();
        for(int i=0; i<p.size(); i++)
            System.out.println(p.get(i));
        return enterprisesRepositories.findAll();
    }

    public Enterprise findOne(int id) {
        Optional<Enterprise> foundVehicle = enterprisesRepositories.findById(id);
        return foundVehicle.orElse(null);
    }

    @Transactional
    public void save(Enterprise enterprise) {
        enterprisesRepositories.save(enterprise);
    }

    @Transactional
    public void delete(int id) {
        enterprisesRepositories.deleteById(id);
    }

    @Transactional
    public void update(int id, Enterprise updateEnterprise) {
        updateEnterprise.setId(id);
        enterprisesRepositories.save(updateEnterprise);
    }
}