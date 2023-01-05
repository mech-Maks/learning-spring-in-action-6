package com.example.learning.repo;

import com.example.learning.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.username = :username") //query is no need, but it makes code more clear
    User findByUsername(String username);
}
