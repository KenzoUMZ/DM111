package br.inatel.pos.dm111.vfp.promotion;

import java.util.List;

public class Promotion {
    private Long id;
    private String title;
    private String description;
    private List<String> categories;
    private Long restaurantId;
    private Double price;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }
    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
