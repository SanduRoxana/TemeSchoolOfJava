package com.endava.Tema6Curs11.repository;

import com.endava.Tema6Curs11.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
