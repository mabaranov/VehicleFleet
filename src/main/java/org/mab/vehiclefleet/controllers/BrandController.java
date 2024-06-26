package org.mab.vehiclefleet.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.mab.vehiclefleet.models.Brand;
import org.mab.vehiclefleet.services.BrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {

    private final BrandServices brandServices;

    @Autowired
    public BrandController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }

    @GetMapping()
    public String index(Model model) {
        //model.addAttribute("vehicle", vehicleServices.findAll());
        model.addAttribute("brands", brandServices.findAll());
        model.addAttribute("brand1", brandServices.findOne(1));
        return "brands/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("brand", brandServices.findOne(id));
        return "brands/show";
    }

    @ResponseBody
    @GetMapping("/allBrands")
    public List<Brand> getBrands() {
        return brandServices.findAll();
    }

}

//@Controller
//@RequestMapping("/brand")
//public class BrandController {
//
//    private final BrandServices brandServices;
//
//    @Autowired
//    public BrandController(BrandServices brandServices) {
//        this.brandServices = brandServices;
//    }
//
//    @GetMapping()
//    public String index(Model model) {
//        //model.addAttribute("vehicle", vehicleServices.findAll());
//        model.addAttribute("brands", brandServices.findAll());
//        model.addAttribute("brand1", brandServices.findOne(1));
//        return "brands/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
////        model.addAttribute("person", personDAO.show(id));
//        model.addAttribute("brand", brandServices.findOne(id));
//        return "brands/show";
//    }
//
//    @ResponseBody
//    @GetMapping("/allBrands")
//    public List<Brand> getBrands() {
//        return brandServices.findAll();
//    }
//
//}