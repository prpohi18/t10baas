package Kevin.kodutoo10;

import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface telekasDAO extends CrudRepository<telekas, Integer>{}
