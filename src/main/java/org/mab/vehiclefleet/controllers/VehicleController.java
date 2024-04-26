package org.mab.vehiclefleet.controllers;

import jakarta.validation.Valid;
import org.mab.vehiclefleet.models.Vehicle;
import org.mab.vehiclefleet.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("vehicles", vehicleServices.findAll());
        return "vehicles/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("vehicle", vehicleServices.findOne(id));
        return "vehicles/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("vehicle") @Valid Vehicle person, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "vehicles/new";
        vehicleServices.save(person);
        return "redirect:/vehicle";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("vehicle", vehicleServices.findOne(id));
        return "vehicles/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("vehicle") @Valid Vehicle person, BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors())
            return "vehicle/edit";
        vehicleServices.update(id, person);
        return "redirect:/vehicle";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        vehicleServices.delete(id);
        return "redirect:/vehicle";
    }
}