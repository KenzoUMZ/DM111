package br.inatel.pos.dm111.vfu.novidade;

import br.inatel.pos.dm111.vfu.persistence.user.User;
import br.inatel.pos.dm111.vfu.persistence.user.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NovidadeService {
    private final NovidadeRepository novidadeRepository;
    private final UserRepository userRepository;

    public NovidadeService(NovidadeRepository novidadeRepository, UserRepository userRepository) {
        this.novidadeRepository = novidadeRepository;
        this.userRepository = userRepository;
    }

    public void processPromotionCreatedEvent(Long promotionId, String title, String description, List<String> categories) {
        try {
            List<User> users = userRepository.getAll();
            for (User user : users) {
                if (user.preferredCategories() != null && !Collections.disjoint(user.preferredCategories(), categories)) {
                    Novidade novidade = new Novidade(UUID.randomUUID().toString(), user.id(), promotionId, title, description);
                    novidadeRepository.addNovidade(user.id(), novidade);
                }
            }
        } catch (Exception e) {
            // log error
        }
    }

    public List<Novidade> getNovidadesByUser(String userId) {
        return novidadeRepository.getNovidadesByUser(userId);
    }
}
