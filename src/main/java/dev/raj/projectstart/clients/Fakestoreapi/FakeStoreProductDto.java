package dev.raj.projectstart.clients.Fakestoreapi;

import dev.raj.projectstart.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long Id;
    private String title;
    private int price;

    private String description;
    private String image;
    private String catagory;
    private RatingDto rating;
}
