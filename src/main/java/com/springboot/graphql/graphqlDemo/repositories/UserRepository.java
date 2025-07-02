package com.springboot.graphql.graphqlDemo.repositories;

import com.springboot.graphql.graphqlDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
