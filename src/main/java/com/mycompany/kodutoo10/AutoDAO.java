package com.mycompany.kodutoo10;
import javax.transaction.*;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface AutoDAO extends CrudRepository<Auto, Integer>{}