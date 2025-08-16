package br.inatel.pos.dm111.vfu.event;

import br.inatel.pos.dm111.vfu.novidade.NovidadeService;
import org.springframework.stereotype.Component;

@Component
public class PromotionCreatedEventListener {
    private final NovidadeService novidadeService;

    public PromotionCreatedEventListener(NovidadeService novidadeService) {
        this.novidadeService = novidadeService;
    }

    // Simulação de recebimento de evento (em produção, seria via PubSub listener)
    public void onPromotionCreated(PromotionCreatedEvent event) {
        novidadeService.processPromotionCreatedEvent(
            event.getPromotionId(),
            event.getTitle(),
            event.getDescription(),
            event.getCategories()
        );
    }
}
