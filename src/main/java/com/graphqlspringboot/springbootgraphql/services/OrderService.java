package com.graphqlspringboot.springbootgraphql.services;


import com.graphqlspringboot.springbootgraphql.entites.Order;
import com.graphqlspringboot.springbootgraphql.entites.User;
import com.graphqlspringboot.springbootgraphql.helper.ExceptionHelper;
import com.graphqlspringboot.springbootgraphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    //creating order
    public Order createorder(Order order){
        return orderRepo.save(order);
    }

    //get all order
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    //get order by id
    public Order getOrderById(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return order;
    }

    //delete order
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
