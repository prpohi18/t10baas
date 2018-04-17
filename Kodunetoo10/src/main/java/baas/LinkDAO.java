package Kodunetoo10;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface LinkDAO extends CrudRepository<Link, Integer>{}