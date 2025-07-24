package com.example.demo.Controllers;


import com.example.demo.Entity.Orders;
import com.example.demo.Service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrdersController {

    private final OrdersService ordersService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
 //   @PostMapping
    public Orders  addOrder(@RequestBody Orders orders) {
        return ordersService.addOrder(orders);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }
}
