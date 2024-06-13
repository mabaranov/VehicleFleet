package org.mab.vehiclefleet.controllers;

import jakarta.validation.Valid;
import org.mab.vehiclefleet.models.Brand;
import org.mab.vehiclefleet.models.Driver;
import org.mab.vehiclefleet.models.Vehicle;
import org.mab.vehiclefleet.services.BrandServices;
import org.mab.vehiclefleet.services.DriverServices;
import org.mab.vehiclefleet.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final DriverServices driverServices;

    @Autowired
    public DriverController(DriverServices driverServices) {
        this.driverServices = driverServices;
    }

    @ResponseBody
    @GetMapping("/allDrivers")
    public List<Driver> getDrivers() {
        return driverServices.findAll();
    }

}
