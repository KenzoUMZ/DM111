package br.inatel.pos.dm111.vfu.novidade;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/valefood/users/{userId}/novidades")
public class NovidadeController {
    private final NovidadeService novidadeService;

    public NovidadeController(NovidadeService novidadeService) {
        this.novidadeService = novidadeService;
    }

    @GetMapping
    public List<Novidade> getNovidades(@PathVariable String userId) {
        return novidadeService.getNovidadesByUser(userId);
    }
}
