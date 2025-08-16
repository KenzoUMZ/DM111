package br.inatel.pos.dm111.vfp.event;

import java.util.List;

public class PromotionCreatedEvent {
    private Long promotionId;
    private String title;
    private List<String> categories;
    private Long restaurantId;

    public PromotionCreatedEvent() {}

    public PromotionCreatedEvent(Long promotionId, String title, List<String> categories, Long restaurantId) {
        this.promotionId = promotionId;
        this.title = title;
        this.categories = categories;
        this.restaurantId = restaurantId;
    }

    public Long getPromotionId() { return promotionId; }
    public void setPromotionId(Long promotionId) { this.promotionId = promotionId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }
    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
}
