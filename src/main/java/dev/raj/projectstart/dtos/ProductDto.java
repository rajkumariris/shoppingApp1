package dev.raj.projectstart.dtos;

public class ProductDto {
    private Long Id;
    private String title;
    private int price;

    private String description;
    private String image;
    private String catagory;
    private RatingDto rating;

    public Long getId() {
        return this.Id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public String getCatagory() {
        return this.catagory;
    }

    public RatingDto getRating() {
        return this.rating;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public void setRating(RatingDto rating) {
        this.rating = rating;
    }

    public String toString() {
        return "ProductDto(Id=" + this.getId() + ", title=" + this.getTitle() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", image=" + this.getImage() + ", catagory=" + this.getCatagory() + ", rating=" + this.getRating() + ")";
    }
}
