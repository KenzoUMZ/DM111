package br.inatel.pos.dm111.vfu.event;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valefood/events")
public class EventSimulationController {
    private final PromotionCreatedEventListener listener;

    public EventSimulationController(PromotionCreatedEventListener listener) {
        this.listener = listener;
    }

    @PostMapping("/promotion-created")
    public void simulatePromotionCreated(@RequestBody PromotionCreatedEvent event) {
        listener.onPromotionCreated(event);
    }
}
