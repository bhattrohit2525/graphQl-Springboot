package com.graphqlspringboot.springbootgraphql.controllers;

import com.graphqlspringboot.springbootgraphql.entites.Order;
import com.graphqlspringboot.springbootgraphql.entites.User;
import com.graphqlspringboot.springbootgraphql.services.OrderService;
import com.graphqlspringboot.springbootgraphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    private UserService userService;
    private OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(@Argument String orderDetail,@Argument String address,@Argument Integer price,@Argument int userId){
       User user= userService.getUserById(userId);

        Order order=new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        Order order1=orderService.createorder(order);
        return order1;
    }


    @QueryMapping(name="getOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping(name="getOrder")
    public Order getOrder(@Argument int orderId){
        return orderService.getOrderById(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);

    }
}
