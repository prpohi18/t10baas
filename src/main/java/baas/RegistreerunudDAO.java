package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface RegistreerunudDAO extends CrudRepository<Registreerunud, Integer>{

}