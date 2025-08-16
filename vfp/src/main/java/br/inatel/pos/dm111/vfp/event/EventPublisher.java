package br.inatel.pos.dm111.vfp.event;

public interface EventPublisher {
    void publishPromotionCreated(PromotionCreatedEvent event);
}
