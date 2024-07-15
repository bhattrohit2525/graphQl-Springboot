package com.graphqlspringboot.springbootgraphql.repositories;

import com.graphqlspringboot.springbootgraphql.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    //custom query and finder methods
}
