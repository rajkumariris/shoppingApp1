package dev.raj.projectstart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends  BaseProduct{

    private int price;
    private String Title;
    private String description;
    @ManyToOne
    private Catagories catagory;
    private String imageUrl;
}
