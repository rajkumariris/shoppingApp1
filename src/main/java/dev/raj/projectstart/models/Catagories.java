package dev.raj.projectstart.models;

import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Catagories extends BaseProduct {
    private  String name;
    private String description;
    @OneToMany(mappedBy = "catagory",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Product> products;
}
