package br.inatel.pos.dm111.vfu.novidade;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class NovidadeRepository {
    private final Map<String, List<Novidade>> novidadesPorUsuario = new HashMap<>();

    public void addNovidade(String userId, Novidade novidade) {
        novidadesPorUsuario.computeIfAbsent(userId, k -> new ArrayList<>()).add(novidade);
    }

    public List<Novidade> getNovidadesByUser(String userId) {
        return novidadesPorUsuario.getOrDefault(userId, Collections.emptyList());
    }
}
