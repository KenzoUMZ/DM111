package br.inatel.pos.dm111.vfu.novidade;

public class Novidade {
    private String id;
    private String userId;
    private Long promotionId;
    private String title;
    private String description;

    public Novidade() {}

    public Novidade(String id, String userId, Long promotionId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.promotionId = promotionId;
        this.title = title;
        this.description = description;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Long getPromotionId() { return promotionId; }
    public void setPromotionId(Long promotionId) { this.promotionId = promotionId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
