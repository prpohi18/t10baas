package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface AutodDAO extends CrudRepository<Autod, Integer>{

}