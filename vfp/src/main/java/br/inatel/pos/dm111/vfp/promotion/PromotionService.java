package br.inatel.pos.dm111.vfp.promotion;

import org.springframework.stereotype.Service;
import br.inatel.pos.dm111.vfp.event.EventPublisher;
import br.inatel.pos.dm111.vfp.event.PromotionCreatedEvent;
import java.util.*;

@Service
public class PromotionService {
    private final Map<Long, Promotion> promotions = new HashMap<>();
    private long nextId = 1;
    private final EventPublisher eventPublisher;

    public PromotionService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Promotion create(Promotion promotion) {
        promotion.setId(nextId++);
        promotions.put(promotion.getId(), promotion);
        // Publica evento de criação de promoção
        PromotionCreatedEvent event = new PromotionCreatedEvent(
            promotion.getId(),
            promotion.getTitle(),
            promotion.getCategories(),
            promotion.getRestaurantId()
        );
        eventPublisher.publishPromotionCreated(event);
        return promotion;
    }

    public List<Promotion> listAll() {
        return new ArrayList<>(promotions.values());
    }

    public Promotion getById(Long id) {
        return promotions.get(id);
    }

    public Promotion update(Long id, Promotion promotion) {
        promotion.setId(id);
        promotions.put(id, promotion);
        return promotion;
    }

    public void delete(Long id) {
        promotions.remove(id);
    }
}
