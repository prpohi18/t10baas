package baas;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface PlaneetDAO extends CrudRepository<Planeet, Integer>{}