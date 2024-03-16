package dev.raj.projectstart.models;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Catagories extends BaseProduct {
    private  String name;
    private String description;
    @OneToMany(mappedBy = "catagory")
    private List<Product> products;
}
