package com.example.demo.Controllers;


import com.example.demo.Entity.Category;
import com.example.demo.Entity.OrderItems;
import com.example.demo.Service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("orderitems")
public class OrderItemsController {

    private final OrderItemsService orderItemsService;

    @PostMapping
    public OrderItems addOrderItems(@RequestBody OrderItems orderItems) {

        return orderItemsService.addOrderItems(orderItems);
    }

    @GetMapping
    public List<OrderItems> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }
}
