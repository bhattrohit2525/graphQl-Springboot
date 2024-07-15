package com.graphqlspringboot.springbootgraphql.repositories;

import com.graphqlspringboot.springbootgraphql.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
     //custom query and finder methods
}
