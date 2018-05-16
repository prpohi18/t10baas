package maritana.geenid;

import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface sportsmanDAO extends CrudRepository<sportsman, Integer> {
    // public GenesDB findByGeneName(String name);
}
