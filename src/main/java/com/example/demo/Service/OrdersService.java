package com.example.demo.Service;

import com.example.demo.Entity.Orders;
import com.example.demo.Repository.OrdersRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public Orders addOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}
