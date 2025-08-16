package br.inatel.pos.dm111.vfp.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleEventPublisher implements EventPublisher {
    private static final Logger log = LoggerFactory.getLogger(SimpleEventPublisher.class);

    @Override
    public void publishPromotionCreated(PromotionCreatedEvent event) {
        // Aqui você integraria com o PubSub real (Google, Kafka, etc)
        log.info("PromotionCreatedEvent published: {}", event);
    }
}
