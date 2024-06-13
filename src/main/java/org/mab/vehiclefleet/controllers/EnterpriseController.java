package org.mab.vehiclefleet.controllers;

import org.mab.vehiclefleet.models.Driver;
import org.mab.vehiclefleet.models.Enterprise;
import org.mab.vehiclefleet.services.DriverServices;
import org.mab.vehiclefleet.services.EnterpriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpriseServices enterpriseServices;

    @Autowired
    public EnterpriseController(EnterpriseServices enterpriseServices) {
        this.enterpriseServices = enterpriseServices;
    }

    @ResponseBody
    @GetMapping("/allEnterprises")
    public List<Enterprise> getEnterprises() {
        return enterpriseServices.findAll();
    }

}
