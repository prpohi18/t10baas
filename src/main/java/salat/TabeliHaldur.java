package salat;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;


@Transactional
public interface TabeliHaldur extends CrudRepository<Toiduained, Integer> {


}