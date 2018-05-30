package krislyn.andmebaas;

import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface lapsDAO extends CrudRepository<Laps, Integer>{}