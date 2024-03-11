package dev.raj.projectstart.controllers;

import dev.raj.projectstart.services.CatagoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatagoryController {
    CatagoryService catagoryService;
    public CatagoryController(CatagoryService catagoryservice){
        this.catagoryService = catagoryservice;
    }

    @GetMapping("/products/getall")
    public String getAllCatagories(){
        return "givi all catagories";
    }
    public String getinProductsCatagories(){
        return "returng product in catagories";
    }
}
