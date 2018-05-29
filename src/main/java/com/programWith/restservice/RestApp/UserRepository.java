package com.programWith.restservice.RestApp;

import org.springframework.data.repository.CrudRepository;

// Teeb tabeli? SpringiBooti oma teema
import com.programWith.restservice.RestApp.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

}