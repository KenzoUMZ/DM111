
package br.inatel.pos.dm111.vfp.promotion;

import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    public Promotion createPromotion(@RequestBody Promotion promotion, @RequestParam String userType) {
        if (!"RESTAURANT".equalsIgnoreCase(userType)) {
            throw new RuntimeException("Apenas usuários do tipo RESTAURANT podem criar promoções.");
        }
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
    public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion,
            @RequestParam String userType) {
        if (!"RESTAURANT".equalsIgnoreCase(userType)) {
            throw new RuntimeException("Apenas usuários do tipo RESTAURANT podem atualizar promoções.");
        }
        return promotionService.update(id, promotion);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id, @RequestParam String userType) {
        if (!"RESTAURANT".equalsIgnoreCase(userType)) {
            throw new RuntimeException("Apenas usuários do tipo RESTAURANT podem deletar promoções.");
        }
        promotionService.delete(id);
    }
}
