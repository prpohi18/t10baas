package baas;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface Tudengid extends CrudRepository<Tudeng, String>{}