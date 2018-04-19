package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface telefonDAO extends CrudRepository<telefon, Integer>{}