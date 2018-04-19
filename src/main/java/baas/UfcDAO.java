package ufc_baas;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface UfcDAO extends CrudRepository<Ufc, Integer>{}