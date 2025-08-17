package br.inatel.pos.dm111.vfp.promotion;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    // Endpoint para listar promoções por categorias de interesse do usuário
    @GetMapping("/by-categories")
    public List<Promotion> listPromotionsByCategories(@RequestParam List<String> categories) {
        return promotionService.listByCategories(categories);
    }

    @PostMapping
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionService.create(promotion);
    }

    @GetMapping
    public List<Promotion> listPromotions() {
        return promotionService.listAll();
    }

    @GetMapping("/{id}")
    public Promotion getPromotion(@PathVariable Long id) {
        return promotionService.getById(id);
    }

    @PutMapping("/{id}")
    public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {
        return promotionService.update(id, promotion);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id) {
        promotionService.delete(id);
    }
}
