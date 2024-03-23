package dev.raj.projectstart.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends  BaseProduct{

    private int price;
    private String Title;
    private String description;
    @ManyToOne(cascade={CascadeType.PERSIST},fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private Catagories catagory;
    private String imageUrl;
}
