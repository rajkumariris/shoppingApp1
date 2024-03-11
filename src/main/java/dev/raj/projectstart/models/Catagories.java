package dev.raj.projectstart.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Catagories extends BaseProduct {
    private  String name;
    private String description;

     private List<Product> products;
}
