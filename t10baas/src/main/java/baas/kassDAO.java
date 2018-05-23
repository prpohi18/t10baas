package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface kassDAO extends CrudRepository<kass, Integer>{}