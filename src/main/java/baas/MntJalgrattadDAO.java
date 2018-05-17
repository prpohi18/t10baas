package baas;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface MntJalgrattadDAO extends CrudRepository<Maanteejalgrattad, Integer>{}