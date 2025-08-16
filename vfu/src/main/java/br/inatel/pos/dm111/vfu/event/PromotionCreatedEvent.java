package br.inatel.pos.dm111.vfu.event;

import java.util.List;

public class PromotionCreatedEvent {
    private Long promotionId;
    private String title;
    private String description;
    private List<String> categories;

    public PromotionCreatedEvent() {}

    public PromotionCreatedEvent(Long promotionId, String title, String description, List<String> categories) {
        this.promotionId = promotionId;
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    public Long getPromotionId() { return promotionId; }
    public void setPromotionId(Long promotionId) { this.promotionId = promotionId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }
}
