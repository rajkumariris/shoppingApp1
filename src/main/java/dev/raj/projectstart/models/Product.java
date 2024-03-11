package dev.raj.projectstart.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends  BaseProduct{
    private String name;
    private int price;
    private String Title;
    private String description;

    private Catagories catagory;

    private String imageUrl;
}
