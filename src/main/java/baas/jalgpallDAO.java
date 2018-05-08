package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface jalgpallDAO extends CrudRepository<jalgpall, Integer>{

}