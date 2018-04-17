package baas;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface RullnokkDAO extends CrudRepository<Rullnokk, String>{}