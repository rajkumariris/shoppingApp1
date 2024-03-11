package dev.raj.projectstart.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private Long Id;
    private String title;
    private int price;

    private String description;
    private String image;
    private String catagory;
}
