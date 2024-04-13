package org.mab.vehiclefleet.controllers;

import org.mab.vehiclefleet.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleServices vehicleServices;

    @Autowired
    public VehicleController(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    @GetMapping()
    public String index(Model model) {
        //model.addAttribute("vehicle", vehicleServices.findAll());
        model.addAttribute("vehicles", vehicleServices.findAll());
        return "vehicles/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("vehicle", vehicleServices.findOne(id));
        return "vehicles/show";
    }
}