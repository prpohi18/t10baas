package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface koerDAO extends CrudRepository<koer, Integer>{}