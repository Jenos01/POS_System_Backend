package com.example.demo.Service;

import com.example.demo.Entity.OrderItems;
import com.example.demo.Repository.OrderItemsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderItemsService {


    private final OrderItemsRepository orderItemsRepository;

    public OrderItems addOrderItems(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }
}
