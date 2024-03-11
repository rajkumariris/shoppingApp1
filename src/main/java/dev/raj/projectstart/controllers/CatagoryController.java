package dev.raj.projectstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatagoryController {

    @GetMapping("/products/getall")
    public String getAllCatagories(){
        return "givi all catagories";
    }
    public String getinProductsCatagories(){
        return "returng product in catagories";
    }
}
