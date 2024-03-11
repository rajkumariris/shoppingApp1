package dev.raj.projectstart.dtos;

import dev.raj.projectstart.models.Catagories;
import dev.raj.projectstart.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class getSingleProductResponseDto {
   private Product product;
}
